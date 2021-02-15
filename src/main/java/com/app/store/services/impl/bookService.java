package com.app.store.services.impl;

import com.app.store.entity.book;
import com.app.store.repositories.bookRepository;
import com.app.store.services.IbookSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class bookService implements IbookSer {

    private bookRepository bookRepository;
    @Autowired
    public bookService(bookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public book createBook(book book) {
        return this.bookRepository.save(book);

    }

    @Override
    public book updateBook(UUID id, book book) {
        return this.bookRepository.save(book);

    }

    @Override
    public void deleteBook(UUID id) {
        this.bookRepository.deleteById(id);

    }


}
