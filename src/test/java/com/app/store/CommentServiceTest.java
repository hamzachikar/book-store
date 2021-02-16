package com.app.store;

import static org.assertj.core.api.Assertions.assertThat;
import com.app.store.entity.Book;
import com.app.store.entity.Comment;
import com.app.store.repositories.BookRepository;
import com.app.store.repositories.CommentRepository;
import com.app.store.services.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    CommentRepository commentRepository;
    @InjectMocks
    CommentServiceImpl commentServiceImpl;
    //boock service test
    @Test
    public void should_add_a_comment_to_book(){
        String bookName="book";
        UUID idBook=UUID.randomUUID();
        String commentTxt="comment";
        Comment commentToSave=new Comment(0,commentTxt);
        Comment savedComment=new Comment(1,commentTxt);
        List<Comment> comments=new ArrayList();
        comments.add(savedComment);
        Book book=new Book(idBook,bookName,null);
        Optional<Book> bookOpt=Optional.of(book);
        Book updatedBook=new Book(idBook,bookName,comments);
        given(bookRepository.findById(idBook)).willReturn(bookOpt);
        given(commentRepository.save(commentToSave)).willReturn(savedComment);
        given(bookRepository.save(book)).willReturn(updatedBook);
        assertThat(commentServiceImpl.add(idBook,commentToSave))
                .isEqualTo(savedComment);
    }
    @Test
    public void should_update_a_comment(){
        int idComment=1;
        Comment updatedComment=new Comment(idComment,"commentUpdated");
        Optional optUpdatedComment=Optional.of(updatedComment);
        given(commentRepository.save(updatedComment)).willReturn(updatedComment);
        given(commentRepository.findById(idComment)).willReturn(optUpdatedComment);
        assertThat(commentServiceImpl.update(idComment,updatedComment))
                .isEqualTo(updatedComment);
    }
}
