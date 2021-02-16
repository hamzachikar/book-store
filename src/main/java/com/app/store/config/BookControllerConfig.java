package com.app.store.config;

import com.app.store.rest.BookController;
import com.app.store.services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookControllerConfig {
    @Bean
    public BookController bookController(BookService bookService){
        return new BookController(bookService);
    }
}
