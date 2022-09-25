package de.eccogaming.isbnservice.mapper;

import de.eccogaming.isbnservice.models.isbn.Author;
import de.eccogaming.isbnservice.models.isbn.Book;
import de.eccogaming.isbnservice.models.isbn.dtos.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMapper {

    // book to dto
    public BookDto mapBookToDto(Book book) {
        return BookDto.builder()
                .name(book.getDetails().getTitle())
                .authors(extractAuthorsToList(book.getDetails().getAuthors()))
                .releaseYear(1)
                .isbn(book.getDetails().getIsbn_13()[0])
                .build();
    }

    private List<String> extractAuthorsToList(Author[] authors) {
        ArrayList<String> authorList = new ArrayList<>();
        for (Author author : authors) {
            authorList.add(author.getName());
        }
        return authorList;
    }
}
