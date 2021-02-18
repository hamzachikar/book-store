package com.app.store.controllers;


import com.app.store.entity.Comment;
import com.app.store.rest.CommentController;
import com.app.store.services.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CommentController.class)
class CommentControllerTest {
    @MockBean
    CommentService commentService;
    @Autowired
    MockMvc mockMvc;
    @Test
    void should_return_a_book_by_id() throws Exception {
        int id=1;
        given(commentService.findById(id))
                .willReturn(new Comment(1,"comment"));

        mockMvc.perform(get("/comments/"+id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.commentText", is("comment")));
    }
}