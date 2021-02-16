package com.app.store.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private UUID Id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Comment> comments;
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}

