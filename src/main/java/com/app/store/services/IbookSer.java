package com.app.store.services;

import com.app.store.entity.book;

import java.util.UUID;

public interface IbookSer {
    public abstract book createBook(book book);
    public abstract book updateBook(UUID id, book book);
    public abstract void deleteBook(UUID id);



}
