package com.app.store.rest;





import com.app.store.entity.book;
import com.app.store.repositories.bookRepository;

import com.app.store.services.IbookSer;
import com.app.store.services.impl.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
public class bookController {
   private  IbookSer ibookSer ;
   @Autowired

    public bookController(IbookSer ibookSer) {
        this.ibookSer = ibookSer;
    }
    @PostMapping("/addBook")
    book newbook(@RequestBody book newbook) {
        return ibookSer.createBook(newbook);
    }
    @DeleteMapping("/book/{id}")
    void deletebook(@PathVariable UUID id) {
        ibookSer.deleteBook(id);
    }
    @PutMapping("/book/{id}")
    book update(@RequestBody book book, @PathVariable UUID id) {

        return ibookSer.updateBook(id, book);
    }
}

