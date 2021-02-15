package com.app.store.rest;





import com.app.store.entity.Book;

import com.app.store.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
   private IBookService bookService;

    //book CRUD functions

    @PostMapping("/add")
    ResponseEntity<Book> newbook(@RequestBody Book newbook) {
        return bookService.createBook(newbook);
    }

    @DeleteMapping("/delete/{id}")
    void deletebook(@PathVariable UUID id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Book> update(@RequestBody Book book, @PathVariable UUID id) {
        return bookService.updateBook(id, book);
    }

}

