package com.app.store.services.impl;

import com.app.store.entity.Book;
import com.app.store.entity.Comment;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    public CommentServiceImpl(CommentRepository commentRepository,BookRepository bookRepository){
        this.bookRepository=bookRepository;
        this.commentRepository=commentRepository;
    }
    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public void delete(int idComment) {
        this.commentRepository.deleteById(idComment);
    }

    @Override
    public Comment add(UUID idBook, Comment comment) {
        Optional<Book> bookFoundByIdBook=this.bookRepository.findById(idBook);
        if(bookFoundByIdBook.isPresent()){
            comment=this.commentRepository.save(comment);
            Book book=bookFoundByIdBook.get();
            book.addComment(comment);
            this.bookRepository.save(book);
            return comment;
        }
        else{
            return null;
        }
    }

    @Override
    public Comment update(int idComment, Comment comment) {
        Optional<Comment> commentFound=this.commentRepository.findById(idComment);
        if(commentFound.isPresent()){
            Comment cFound=commentFound.get();
            cFound.setComment(comment.getComment());
            return this.commentRepository.save(cFound);
        }
        return null;
    }

    @Override
    public Comment findById(int id) {
        return this.commentRepository.findById(id).get();
    }
}
