package com.example.postgesqlherokutest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name="editor_id", nullable=false, referencedColumnName = "id")
    private Editor editor;

    @OneToOne
    @JoinColumn(name="book_id", nullable=false, referencedColumnName = "id")
    private Book book;

    public Stock(int amount, Editor editor, Book book ) {
        this.amount = amount;
        this.editor = editor;
        this.book = book;
    }
}
