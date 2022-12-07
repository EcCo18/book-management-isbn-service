package de.eccogaming.isbnservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.eccogaming.isbnservice.models.isbn.Book;
import de.eccogaming.isbnservice.models.isbn.BookWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class IsbnApiService {

    @Value("${environment.isbn-url}")
    private String isbnInformationUrl;

    WebClient webClient = WebClient.create();
    ObjectMapper objectMapper = new ObjectMapper();

    // ToDo refactor, add better exception when string is null, add validation
    public Book getBookDataWithISBN(String isbn) throws Exception {
        log.info("receiving data from " + isbnInformationUrl + ". for isbn: " + isbn);
        String isbnInformationUrlReplaced = isbnInformationUrl.replace("ISBN_HOLDER", isbn);

        String bookData = webClient.get()
                .uri(isbnInformationUrlReplaced)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        if(bookData != null && bookData.contains("bib_key")) {
            System.out.println(bookData);
            bookData = bookData.replaceFirst("ISBN:" + isbn, "book"); // replace changing json key
            BookWrapper bookWrapper = objectMapper.readValue(bookData, BookWrapper.class);
            return bookWrapper.getBook();
        }
        throw new Exception("couldn't get book data");
    }
}
