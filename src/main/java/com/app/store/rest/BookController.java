package com.app.store.rest;

import com.app.store.entity.Book;
import com.app.store.services.BookService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** This is the book rest controller. */
@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  /**
   * Instantiates a new Book controller.
   *
   * @param bookService the book service
   */
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Get a List of all books.
   *
   * @return the List of books
   */
  @GetMapping
  public ResponseEntity<List<Book>> getAll() {
    List<Book> books = bookService.findAll();
    return ResponseEntity.ok(books);
  }

  /**
   * Get a book by id.
   *
   * @param id the id
   * @return the book
   */
  @GetMapping("/{id}")
  public ResponseEntity<Book> getById(@PathVariable UUID id) {
    Book book = bookService.findById(id);
    return ResponseEntity.ok(book);
  }

  /**
   * Create book.
   *
   * @param newbook the newbook
   * @return the book
   */
  @PostMapping
  public Book create(@RequestBody Book newbook) {
    return bookService.create(newbook);
  }

  /**
   * Delete a book by id.
   *
   * @param id the id
   */
  @DeleteMapping("/{id}")
  public void delete(@PathVariable UUID id) {
    bookService.delete(id);
  }

  /**
   * Update a book.
   *
   * @param book the book
   * @return the book
   */
  @PutMapping
  public Book update(@RequestBody Book book) {
    return bookService.update(book);
  }
}
