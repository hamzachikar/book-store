package com.app.store.services.impl;

import com.app.store.entity.Book;
import com.app.store.repositories.BookRepository;
import com.app.store.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class BookService implements IBookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public ResponseEntity<Book> createBook(Book book) {
        return ResponseEntity.ok(this.bookRepository.save(book));
    }
    @Override
    public ResponseEntity<Book> updateBook(UUID id, Book book) {
        Optional<Book> bookFound=this.bookRepository.findById(id);
        if(bookFound.isPresent()){
            Book bFound=bookFound.get();
            bFound.setName(book.getName());
            book.setComments(book.getComments());
            return ResponseEntity.ok(this.bookRepository.save(book));
        }
        return ResponseEntity.badRequest().body(null);
    }
    @Override
    public void deleteBook(UUID id) {
        this.bookRepository.deleteById(id);
    }


}
