package de.eccogaming.isbnservice.models.isbn;

import lombok.Data;

@Data
public class Details {
    private TableContent[] table_of_contents;
    private Description description;
    private String subtitle;
    private String pagination;
    private String[] dewey_decimal_class;
    private TypeValue notes;
    private String[] lccn;
    private String[] subjects;
    private String publish_country;
    private String by_statement;
    private String[] oclc_numbers;
    private String[] publishers;
    private long number_of_pages;
    private String[] isbn_10;
    private long[] covers;
    private String physical_format;
    private String key;
    private Author[] authors;
    private String[] publish_places;
    private Classifications classifications;
    private String[] source_records;
    private String title;
    private String full_title;
    private Classifications identifiers;
    private String[] isbn_13;
    private Languages[] languages;
    private String[] local_id;
    private String publish_date;
    private String copyright_date;
    private Type[] works;
    private Type type;
    private String[] lc_classifications;
    private long latest_revision;
    private long revision;
    private Created created;
    private Created last_modified;
}
