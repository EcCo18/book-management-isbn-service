package de.eccogaming.isbnservice.components;

import de.eccogaming.isbnservice.models.isbn.dtos.BookDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookCreatedListener {

    @KafkaListener(
            topics = "books-newly-created",
            groupId = "isbn-service",
            containerFactory = "bookDtoListener"
    )
    void listener(@Payload BookDto bookDto) {
        System.out.println(bookDto.getName());
    }
}
