package com.app.store;

import com.app.store.rest.BookController;
import com.app.store.rest.CommentController;
import com.app.store.services.impl.BookServiceImpl;
import com.app.store.services.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = {BookController.class, CommentController.class})
public class ControllerTest {
    @MockBean
    BookServiceImpl bookServiceImpl;
    @MockBean
    CommentServiceImpl commentServiceImpl;
    @Autowired
    MockMvc mockMvc;

}
