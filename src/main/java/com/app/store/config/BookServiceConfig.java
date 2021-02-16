package com.app.store.config;

import com.app.store.repositories.BookRepository;
import com.app.store.services.BookService;
import com.app.store.services.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookServiceConfig {
    @Bean
    public BookService bookService(BookRepository bookRepository){
        return new BookServiceImpl(bookRepository);
    }
}
