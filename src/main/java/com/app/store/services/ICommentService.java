package com.app.store.services;

import com.app.store.entity.Comment;

import java.util.List;

public interface ICommentService {
    public Comment saveOrUpdateComment(Comment comment);
    public List<Comment> findAllComments();
    public void deleteCommentById(int idComment);
}
