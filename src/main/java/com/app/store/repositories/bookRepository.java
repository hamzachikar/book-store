package com.app.store.repositories;
import com.app.store.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface bookRepository extends JpaRepository<book, UUID> {

}