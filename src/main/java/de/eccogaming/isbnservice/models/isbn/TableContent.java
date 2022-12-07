package de.eccogaming.isbnservice.models.isbn;

import lombok.Data;

@Data
public class TableContent {
    private int level;
    private String label;
    private String title;
    private String pagenum;
}
