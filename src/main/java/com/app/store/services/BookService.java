package com.app.store.services;

import com.app.store.entity.Book;
import java.util.List;
import java.util.UUID;

public interface BookService {
    Book create(Book book);
    Book update(Book book);
    void delete(UUID id);
    List<Book> findAll();
    Book findById(UUID id);
}
