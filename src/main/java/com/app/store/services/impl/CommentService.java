package com.app.store.services.impl;

import com.app.store.entity.Comment;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {
    private CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }
    @Override
    public Comment saveOrUpdateComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllComments() {
        return this.commentRepository.findAll();
    }

    @Override
    public void deleteCommentById(int idComment) {
        this.commentRepository.deleteById(idComment);
    }
}
