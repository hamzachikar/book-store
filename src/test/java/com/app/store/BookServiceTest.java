package com.app.store;

import com.app.store.entity.Book;
import com.app.store.repositories.BookRepository;
import com.app.store.services.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookServiceImpl bookServiceImpl;

    @Test
    public void should_create_a_book(){
        String bookName="book";
        UUID idBook=UUID.randomUUID();
        Book bookToSave=new Book(null,bookName,null);
        Book expectedBook=new Book(idBook,bookName,null);
        given(bookRepository.save(bookToSave)).willReturn(expectedBook);
        assertThat(bookServiceImpl.create(bookToSave)).isEqualTo(expectedBook);
    }
    @Test
    public void should_update_a_book(){
        String bookName="book";
        UUID idBook=UUID.randomUUID();
        Book bookToUpdate=new Book(idBook,bookName,null);
        Book updatedBook=new Book(idBook,"bookUpdated",null);
        Optional optUpdatedBook=Optional.of(updatedBook);
        given(bookRepository.save(updatedBook)).willReturn(updatedBook);
        given(bookRepository.findById(idBook)).willReturn(optUpdatedBook);
        assertThat(bookServiceImpl.update(idBook,updatedBook))
                .isEqualTo(updatedBook);
    }

}
