package com.app.store.services;



import com.app.store.entity.book;
import com.app.store.repositories.bookRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class bookController {
    private final bookRepository repository;
    bookController(bookRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/addBook")
    book newbook(@RequestBody book newbook) {
        return repository.save(newbook);
    }
    @DeleteMapping("/book/{id}")
    void deletebook(@PathVariable UUID id) {
        repository.deleteById(id);
    }
    @PutMapping("/book/{id}")
    Optional<book> replacebook(@RequestBody book newbook, @PathVariable UUID id) {

        return repository.findById(id)
                .map(book -> {
                    book.setName(newbook.getName());
                    book.setComments(newbook.getComments());
                    return repository.save(book);
                });
    }


}
