package com.example.postgesqlherokutest.model;

import com.example.postgesqlherokutest.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="author_name")
    private String authorName;

    public Author(String authorName ) {
        this.authorName  = authorName ;
    }
}
