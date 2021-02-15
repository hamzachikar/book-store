package com.app.store.services;

import com.app.store.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ICommentService {
    public List<Comment> findAllComments();
    public void deleteCommentById(int idComment);
    public ResponseEntity<Comment> addCommentToBookId(UUID idBook, Comment comment);
    ResponseEntity<Comment> updateComment(int idComment, Comment comment);
}
