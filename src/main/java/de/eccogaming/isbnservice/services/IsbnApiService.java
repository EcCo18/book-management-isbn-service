package de.eccogaming.isbnservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.eccogaming.isbnservice.models.Book;
import de.eccogaming.isbnservice.models.BookWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IsbnApiService {

    @Value("${environment.isbn-url}")
    private String isbnInformationUrl;

    WebClient webClient = WebClient.create();
    ObjectMapper objectMapper = new ObjectMapper();

    // ToDo refactor, add exception when string is null, add validation
    public Book getBookDataWithISBN(String isbn) throws Exception {
        // System.out.println(isbnInformationUrl);
        isbnInformationUrl = isbnInformationUrl.replace("ISBN_HOLDER", isbn);
        // System.out.println(isbnInformationUrl);

        String bookData = webClient.get()
                .uri(isbnInformationUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        if(bookData != null) {
            // System.out.println(bookData);
            bookData = bookData.replaceFirst("ISBN:" + isbn, "book"); // replace changing json key
            // System.out.println(bookData);
            BookWrapper bookWrapper = objectMapper.readValue(bookData, BookWrapper.class);
            return bookWrapper.getBook();
        }
        throw new Exception("couldn't get book data");
    }
}
