package com.app.store.rest;





import com.app.store.entity.Book;

import com.app.store.services.BookService;
import org.springframework.http.ResponseEntity;
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
    List<Book> getAll(){
        return this.bookService.findAll();
    }
    @GetMapping("/{id}")
    Book getById(@PathVariable UUID id){
        return this.bookService.findById(id);
    }
    @PostMapping
    Book create(@RequestBody Book newbook) {
        return bookService.create(newbook);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        bookService.delete(id);
    }
    //return obj
    @PutMapping("/{id}")
    Book update(@RequestBody Book book, @PathVariable UUID id) {
        return bookService.update(id, book);
    }

}

