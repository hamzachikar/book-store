package com.app.store;

import com.app.store.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        System.out.println(bookResponseEntity.getBody().getName());
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody()).isNotNull();
    }

    @Test
    void should_update_a_book_by_id(){
        var id= UUID.fromString("a07b5c8fffc481cb4f9639de41e2419");
        var book=new Book(id,"updated book",new ArrayList<>());
        testRestTemplate.put("http://localhost:"+port+"/books",book,Book.class);
        final ResponseEntity<Book> bookResponseEntity=
                testRestTemplate.getForEntity(
                        "http://localhost:"+port+"/books/"+id.toString(),Book.class);
        bookResponseEntity.getStatusCode().is2xxSuccessful();
        assertThat(bookResponseEntity.getBody().getName()).isEqualTo("updated book");
    }
}
