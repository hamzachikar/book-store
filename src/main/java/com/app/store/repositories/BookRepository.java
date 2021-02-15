package com.app.store.repositories;
import com.app.store.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book,UUID> {
}