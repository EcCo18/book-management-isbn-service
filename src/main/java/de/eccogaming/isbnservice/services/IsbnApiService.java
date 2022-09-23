package de.eccogaming.isbnservice.services;

import de.eccogaming.isbnservice.models.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IsbnApiService {

    @Value("${environment.isbn-url}")
    private String isbnUrl;

    WebClient webClient = WebClient.create();

    public Book getBookDataWithISBN(String isbn) {
        System.out.println(isbnUrl);
        isbnUrl = isbnUrl.replace("ISBN_HOLDER", isbn);
        System.out.println(isbnUrl);

        webClient.get().uri(isbnUrl).retrieve().bodyToMono(Book.class).block();

        return null;
    }
}
