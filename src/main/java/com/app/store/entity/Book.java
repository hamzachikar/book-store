package com.app.store.entity;
import lombok.Data;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Book {
    @Id
    private UUID Id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Comment> comments;

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}

