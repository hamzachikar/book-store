package com.app.store.rest;

import com.app.store.ExceptionHandler.RestExceptionHandler;
import com.app.store.entity.Book;
import com.app.store.entity.BookNotFoundException;
import com.app.store.services.BookService;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
  public ResponseEntity<Optional<Book>> getById(@PathVariable UUID id) {
    Optional<Book> book = Optional.ofNullable(bookService.findById(id));
    return book.map(value -> new ResponseEntity(value , HttpStatus.OK)).orElseThrow(() -> new BookNotFoundException());
  }

  /**
   * Create book.
   *
   * @param newbook the newbook
   * @return the book
   */
  @PostMapping
  public ResponseEntity<Book> create(@RequestBody Book newbook) {
    Book book =bookService.create(newbook);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand().toUri();
      return ResponseEntity.created(location).body(book);

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
    Book book1=bookService.update(book);
    return book1;
  }
}
