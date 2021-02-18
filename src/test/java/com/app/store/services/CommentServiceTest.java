package com.app.store.services;

import com.app.store.entity.Book;
import com.app.store.entity.Comment;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    CommentRepository commentRepository;
    @InjectMocks
    CommentServiceImpl commentServiceImpl;
    //boock service test
    @Test
    void should_add_a_comment_to_book(){
        var id=UUID.randomUUID();
        var commentText="comment";
        Comment comment=new Comment(0,commentText);
        Book book=new Book(id,"book",new ArrayList<>());
        given(bookRepository.findById(id)).willReturn(Optional.of(book));
        given(bookRepository.save(book)).willReturn(book);

        //then
        assertThatCode(()->{commentServiceImpl.add(id,comment);}).doesNotThrowAnyException();
    }
    @Test
    void should_update_a_comment(){
        //given
        var idComment=1;
        var commentText="comment";
        Comment comment=new Comment(idComment,commentText);
        Comment expected=new Comment(idComment,"updated comment");
        given(commentRepository.save(expected)).willReturn(expected);
        //when
        Comment actual=commentServiceImpl.update(expected);

        //then
        assertThat(actual)
                .isEqualTo(expected);
    }

}
