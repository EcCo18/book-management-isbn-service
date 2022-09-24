package de.eccogaming.isbnservice.models.isbn;

import lombok.Data;

@Data
public class Book {
    private String bib_key;
    private String info_url;
    private String preview;
    private String preview_url;
    private String thumbnail_url;
    private Details details;
}
