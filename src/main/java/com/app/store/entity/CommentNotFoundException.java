package com.app.store.entity;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(){
        super("comment not found");
    }
}
