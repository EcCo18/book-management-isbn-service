package de.eccogaming.isbnservice.models.isbn.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private int id;

    @NotNull
    private List<String> authors;

    @Min(1)
    private int releaseYear;

    @NotNull
    private String isbn;
}
