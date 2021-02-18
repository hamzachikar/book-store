package com.app.store.services;

import com.app.store.entity.Book;
import com.app.store.entity.BookNotFoundException;
import com.app.store.repositories.BookRepository;
import com.app.store.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookServiceImpl bookServiceImpl;

    @Test
    void should_create_a_book(){
        //given
        var name="book";
        var id=UUID.randomUUID();
        var bookToSave=new Book(null,name,new ArrayList<>());
        var expectedBook=new Book(id,name,new ArrayList<>());
        given(bookRepository.save(bookToSave)).willReturn(expectedBook);

        //when
        var actual=bookServiceImpl.create(bookToSave);

        //then
        assertThat(actual).isEqualTo(expectedBook);
    }
    @Test
    void should_return_book_by_id(){
        //given
        var id=UUID.randomUUID();
        var name="book";
        var book=new Book(id,name,new ArrayList<>());
        given(bookRepository.findById(id)).willReturn(Optional.of(book));

        //when
        var actual=bookServiceImpl.findById(id);

        //then
        assertThat(actual).isEqualTo(book);

    }
    @Test
    void should_return_book_not_found_exception(){
        //given
        var id=UUID.randomUUID();
        given(bookRepository.findById(any())).willReturn(Optional.ofNullable(null));

        //then
        assertThatThrownBy(()->bookServiceImpl.findById(id)).isInstanceOf(BookNotFoundException.class);
    }
    @Test
    void should_delete_book_by_id(){
        //given
        var id=UUID.randomUUID();
        given(bookRepository.findById(any())).willReturn(Optional.ofNullable(null));

        //then
        assertThatThrownBy(()->bookServiceImpl.findById(id)).isInstanceOf(BookNotFoundException.class);
    }



}
