package de.eccogaming.isbnservice.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class IsbnApiServiceTest{

    @Autowired
    IsbnApiService isbnApiService;

    @Test
    public void test() throws Exception {
        isbnApiService.getBookDataWithISBN("1491950358");
    }

}