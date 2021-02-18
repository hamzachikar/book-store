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
    @GetMapping("/{id}")
    public Comment getById(@PathVariable int id){
        return this.commentService.findById(id);
    }
    @PostMapping("/{idBook}")
    public void save(@PathVariable UUID idBook,@RequestBody Comment comment)throws Exception {
        this.commentService.add(idBook,comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.commentService.delete(id);
    }

    @PutMapping
    public Comment update(@RequestBody Comment comment){
        return this.commentService.update(comment);
    }

}
