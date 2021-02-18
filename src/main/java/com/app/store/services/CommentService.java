package com.app.store.services;

import com.app.store.entity.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> findAll();
    void delete(int idComment);
    void add(UUID idBook, Comment comment);
    Comment update(Comment comment);
    Comment findById(int id);
}
