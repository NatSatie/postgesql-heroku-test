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
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name="isbn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;

    @Column(name="year_release")
    private long yearRelease;

    public Book(String title, Category category, long yearRelease ) {
        this.title = title;
        this.category = category;
        this.yearRelease = yearRelease;
    }
}
