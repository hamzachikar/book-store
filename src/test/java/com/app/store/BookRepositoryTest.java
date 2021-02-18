package com.app.store;

import com.app.store.entity.Book;
import com.app.store.entity.Comment;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    BookRepository bookRepository;
    @Test
    public void should_return_book_by_id(){
        //given
        var book=new Book();
        book.setName("book");
        var idBook=book.getId();
        testEntityManager.persist(book);
        //when
        var actual=bookRepository.findById(idBook);
        //then
        assertThat(book).isEqualTo(actual.get());
    }
}
