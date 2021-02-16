package com.app.store.rest;

import com.app.store.entity.Comment;
import com.app.store.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }

    @PostMapping("/{idBook}")
    public Comment save(@PathVariable UUID idBook,@RequestBody Comment comment){
        return this.commentService.add(idBook,comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.commentService.delete(id);
    }

    @PutMapping("/{id}")
    public Comment update(@PathVariable int id,@RequestBody Comment comment){
        return this.commentService.update(id,comment);
    }

}
