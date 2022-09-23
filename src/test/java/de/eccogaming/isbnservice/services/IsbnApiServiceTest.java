package de.eccogaming.isbnservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    public void test() throws JsonProcessingException {
        isbnApiService.getBookDataWithISBN("1491950358");
    }

}