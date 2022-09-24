package de.eccogaming.isbnservice.models.isbn;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Created {
    private String type;
    private String value;
}
