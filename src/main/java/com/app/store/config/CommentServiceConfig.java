package com.app.store.config;

import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.CommentService;
import com.app.store.services.impl.CommentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentServiceConfig {
    @Bean
    public CommentService commentService(CommentRepository commentRepository, BookRepository bookRepository){
        return new CommentServiceImpl(commentRepository,bookRepository);
    }
}
