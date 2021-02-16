package com.app.store.services.impl;

import com.app.store.entity.Book;
import com.app.store.repositories.BookRepository;
import com.app.store.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public Book create(Book book) {
        return this.bookRepository.save(book);
    }
    @Override
    public Book update(UUID id, Book book) {
        Optional<Book> bookFound=this.bookRepository.findById(id);
        if(bookFound.isPresent()){
            Book bFound=bookFound.get();
            bFound.setName(book.getName());
            book.setComments(book.getComments());
            return this.bookRepository.save(book);
        }
        return null;
    }
    @Override
    public void delete(UUID id) {
        this.bookRepository.deleteById(id);
    }


}
