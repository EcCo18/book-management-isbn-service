package de.eccogaming.isbnservice.services;

import de.eccogaming.isbnservice.mapper.BookMapper;
import de.eccogaming.isbnservice.models.isbn.Book;
import de.eccogaming.isbnservice.models.isbn.dtos.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookInformationProcessService {

    private final KafkaTemplate<String, BookDto> kafkaTemplate;
    private final BookMapper bookMapper;

    public void processBookInformation(Book book, int bookId) {
        log.info("send complete book information to topic isbn-book-information");
        BookDto bookDto = bookMapper.mapBookToDto(book);
        bookDto.setId(bookId);
        kafkaTemplate.send("isbn-book-information", bookDto);
    }
}
