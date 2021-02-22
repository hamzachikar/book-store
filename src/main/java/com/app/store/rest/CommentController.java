package com.app.store.rest;

import com.app.store.entity.Comment;
import com.app.store.services.CommentService;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

/** The Comment rest controller. */
@RestController
@RequestMapping("/comments")
public class CommentController {
  private final CommentService commentService;

  /**
   * Instantiates a new Comment controller.
   *
   * @param commentService the comment service
   */
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  /**
   * Get comment by id.
   *
   * @param id the id
   * @return the comment
   */
  @GetMapping("/{id}")
  public Comment getById(@PathVariable int id) {
    return this.commentService.findById(id);
  }

  /**
   * Add a comment to a Book.
   *
   * @param idBook the id book
   * @param comment the comment
   */
  @PostMapping("/{idBook}")
  public void save(@PathVariable UUID idBook, @RequestBody Comment comment) {
    this.commentService.add(idBook, comment);
  }

  /**
   * Delete a comment.
   *
   * @param id the id
   */
  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    this.commentService.delete(id);
  }

  /**
   * Update a comment.
   *
   * @param comment the comment
   * @return the comment
   */
  @PutMapping
  public Comment update(@RequestBody Comment comment) {
    return this.commentService.update(comment);
  }
}
