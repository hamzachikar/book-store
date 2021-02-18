package com.app.store;

import com.app.store.entity.Comment;
import com.app.store.repositories.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CommentRepositoriesTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void should_return_comment_by_id(){
        //given
        var comment=new Comment(0,"test");
        testEntityManager.persist(comment);
        comment.setId(1);
        //when
        var expected=commentRepository.findById(1);

        //then
        assertThat(comment).isEqualTo(expected.get());
    }
}
