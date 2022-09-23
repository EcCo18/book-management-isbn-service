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
    private String isbnUrl;

    WebClient webClient = WebClient.create();
    ObjectMapper objectMapper = new ObjectMapper();

    // ToDo refactor
    public Book getBookDataWithISBN(String isbn) throws JsonProcessingException {
        System.out.println(isbnUrl);
        isbnUrl = isbnUrl.replace("ISBN_HOLDER", isbn);
        System.out.println(isbnUrl);

        String test = webClient.get()
                .uri(isbnUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(test);
        test = test.replaceFirst("ISBN:" + isbn, "book"); // replace changing key
        System.out.println(test);

        BookWrapper bookWrapper = objectMapper.readValue(test, BookWrapper.class);

        return bookWrapper.getBook();
    }
}
