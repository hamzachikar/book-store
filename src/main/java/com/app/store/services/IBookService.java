package com.app.store.services;

import com.app.store.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IBookService {
    public ResponseEntity<Book> createBook(Book book);
    public ResponseEntity<Book> updateBook(UUID Id, Book book);
    public void deleteBook(UUID Id);



}
