package com.app.store.rest;

import com.app.store.entity.Comment;
import com.app.store.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private ICommentService commentService;
    @Autowired
    public CommentController(ICommentService commentService){
        this.commentService=commentService;
    }

    @PostMapping("/add/{idBook}")
    public ResponseEntity<Comment> saveCommentToBookId(@PathVariable UUID idBook,@RequestBody Comment comment){
        return this.commentService.addCommentToBookId(idBook,comment);
    }

    @DeleteMapping("/delete/{idComment}")
    public void deleteCommentById(@PathVariable int idComment){
        this.commentService.deleteCommentById(idComment);
    }

    @PutMapping("/update/{idComment}")
    public ResponseEntity<Comment> updateComment(@PathVariable int idComment,@RequestBody Comment comment){
        return this.commentService.updateComment(idComment,comment);
    }

}
