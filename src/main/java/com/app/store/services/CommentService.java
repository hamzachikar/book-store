package com.app.store.services;

import com.app.store.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<Comment> findAll();
    void delete(int idComment);
    Comment add(UUID idBook, Comment comment);
    Comment update(int idComment, Comment comment);
}
