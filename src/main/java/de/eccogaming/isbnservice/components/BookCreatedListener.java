package de.eccogaming.isbnservice.components;

import de.eccogaming.isbnservice.models.isbn.dtos.BookDto;
import de.eccogaming.isbnservice.services.BookInformationProcessService;
import de.eccogaming.isbnservice.services.IsbnApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookCreatedListener {

    private final IsbnApiService isbnApiService;
    private final BookInformationProcessService bookInformationProcessService;

    // ToDo process book
    @KafkaListener(
            topics = "books-newly-created",
            groupId = "isbn-service",
            containerFactory = "bookDtoListener"
    )
    void listener(@Payload BookDto bookDto) {
        log.info("received book with id=" + bookDto.getId() + " isbn=" + bookDto.getIsbn());
        try {
            bookInformationProcessService.processBookInformation(
                    isbnApiService.getBookDataWithISBN(bookDto.getIsbn())
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
