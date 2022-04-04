package com.example.postgesqlherokutest.repository;

import com.example.postgesqlherokutest.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByAuthorNameContaining(String author_name);
}
