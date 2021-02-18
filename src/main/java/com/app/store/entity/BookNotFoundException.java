package com.app.store.entity;


public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(){
        super("book not found");
    }
}
