package com.app.store.rest;





import com.app.store.entity.Book;

import com.app.store.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping
    public List<Book> getAll(){
        return this.bookService.findAll();
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable UUID id){
        return this.bookService.findById(id);
    }
    @PostMapping
    public Book create(@RequestBody Book newbook) {
        return bookService.create(newbook);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bookService.delete(id);
    }
    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

}

