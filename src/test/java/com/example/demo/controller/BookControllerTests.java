package com.example.demo.controller;

import com.example.demo.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_books_get_all_api() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/book/all")
        ).andExpect(MockMvcResultMatchers.status().isOk());

//        Assertions.assertEquals("[]", response);
    }

    @Test
    public void test_books_insert_book_api() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/book/insert")
                                .content(
                                        "{\n" +
                                                "    \"id\": 123454,\n" +
                                                "    \"name\": \"Harry potter\",\n" +
                                                "    \"author\": \"JK Rowling\",\n" +
                                                "    \"publishedYear\": \"2001\",\n" +
                                                "    \"publisher\": {\n" +
                                                "        \"name\": \"xyz\",\n" +
                                                "        \"address\": \"abc\"\n" +
                                                "    },\n" +
                                                "    \"cost\": 150\n" +
                                                "}"
                                ).contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk());
//        Book book = bookService.getMap().get("123454");
//        Assertions.assertEquals("Harry potter", book.getName());
    }

    @Test
    public void test_books_insert_book_api_2() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/book/insert")
                        .content(
                                "{\n" +
                                        "    \"id\": 123455,\n" +
                                        "    \"name\": \"\",\n" +
                                        "    \"author\": \"JK Rowling\",\n" +
                                        "    \"publishedYear\": \"2001\",\n" +
                                        "    \"publisher\": {\n" +
                                        "        \"name\": \"xyz\",\n" +
                                        "        \"address\": \"abc\"\n" +
                                        "    },\n" +
                                        "    \"cost\": 150\n" +
                                        "}"
                        ).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
//        Book book = bookService.getMap().get("123454");
//        Assertions.assertEquals("Harry potter", book.getName());
    }
}
