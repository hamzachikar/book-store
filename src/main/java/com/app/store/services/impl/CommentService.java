package com.app.store.services.impl;

import com.app.store.entity.Book;
import com.app.store.entity.Comment;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Comment> findAllComments() {
        return this.commentRepository.findAll();
    }

    @Override
    public void deleteCommentById(int idComment) {
        this.commentRepository.deleteById(idComment);
    }

    @Override
    public ResponseEntity<Comment> addCommentToBookId(UUID idBook, Comment comment) {
        Optional<Book> bookFoundByIdBook=this.bookRepository.findById(idBook);
        if(bookFoundByIdBook.isPresent()){
            comment=this.commentRepository.save(comment);
            Book book=bookFoundByIdBook.get();
            book.addComment(comment);
            this.bookRepository.save(book);
            return ResponseEntity.ok(comment);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    @Override
    public ResponseEntity<Comment> updateComment(int idComment, Comment comment) {
        Optional<Comment> commentFound=this.commentRepository.findById(idComment);
        if(commentFound.isPresent()){
            Comment cFound=commentFound.get();
            cFound.setComment(comment.getComment());
            return ResponseEntity.ok(this.commentRepository.save(cFound));
        }
        return ResponseEntity.badRequest().body(null);
    }
}
