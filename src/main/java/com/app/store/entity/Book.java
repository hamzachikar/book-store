package com.app.store.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Comment> comments;
    public Book addComment(Comment comment) {
        Optional.of(this.comments).ifPresentOrElse(c->c.add(comment),()->{
            this.comments=new ArrayList<>();
            comments.add(comment);
        });
        return this;
    }
}

