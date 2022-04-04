package com.example.postgesqlherokutest.repository;

import com.example.postgesqlherokutest.model.Anime;
import com.example.postgesqlherokutest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
}