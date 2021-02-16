package com.app.store.config;

import com.app.store.rest.CommentController;
import com.app.store.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentControllerConfig {
    @Bean
    public CommentController commentController(CommentService commentService){
        return new CommentController(commentService);
    }
}
