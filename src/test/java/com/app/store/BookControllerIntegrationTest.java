package com.app.store;

import com.app.store.entity.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {
    @LocalServerPort
    int port;
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void should_create_a_book(){
        var book=new Book("book",new ArrayList<>());
         final ResponseEntity<Book> bookResponseEntity=
                 testRestTemplate.postForEntity("http://localhost:"+port+"/books",book,Book.class);
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody()).isNotNull();
    }
    @Test
    void should_return_book_by_id(){
        var id= UUID.fromString("e27294b9-8402-4f90-81ed-357c7bbc7a70");
        final ResponseEntity<Book> bookResponseEntity=
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/books/"+id.toString(),Book.class);
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody().getName()).isEqualTo("book dataBase");
    }
    @Test
    void should_update_a_book_by_id(){
        var id= UUID.fromString("e27294b9-8402-4f90-81ed-357c7bbc7a70");
        var book=new Book(id,"book",new ArrayList<>());
        testRestTemplate.put("http://localhost:"+port+"/books",book,Book.class);
        final ResponseEntity<Book> bookResponseEntity=
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/books/"+id.toString(),Book.class);
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody().getName()).isEqualTo("book");
    }

    @Test
    void should_return_List_of_books(){
        final ResponseEntity<List> bookResponseEntity=
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/books",List.class);
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        System.out.println(bookResponseEntity.getBody());
        assertThat(bookResponseEntity.getBody()).isNotNull();
    }

    @Test
    void should_delete_a_book_by_id(){
        var id= UUID.fromString("e27294b9-8402-4f90-81ed-357c7bbc7a70");
        Assertions.assertThatNoException().isThrownBy(
                ()->testRestTemplate.delete("http://localhost:"+port+"/books/"+id.toString())
        );
    }
}
