package com.example.postgesqlherokutest.controller;

import com.example.postgesqlherokutest.model.Author;
import com.example.postgesqlherokutest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    AuthorRepository repository;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(required = false) String authorName) {
        try {
            List<Author> list = new ArrayList<Author>();

            if (authorName == null)
                repository.findAll().forEach(list::add);
            else
                repository.findByAuthorNameContaining(authorName).forEach(list::add);

            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> create(@RequestBody Author local) {
        try {
            Author _local = repository
                    .save(new Author(
                            local.getAuthorName()
                    ));
            return new ResponseEntity<>(_local, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
