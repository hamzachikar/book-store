package com.app.store.services;

import com.app.store.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book create(Book book);
    Book update(UUID Id, Book book);
    void delete(UUID Id);
    List<Book> findAll();
    Book findById(UUID id);
}
