package com.app.store.entity;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class
book {
    @Id
    private UUID Id;
    private String name;
    private String comments;
}

