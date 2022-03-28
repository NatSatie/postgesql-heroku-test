package com.example.postgesqlherokutest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="year")
    private String year;

    @Column(name="genre")
    private String genre;

    public Anime(String name, String year, String genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
    }
}
