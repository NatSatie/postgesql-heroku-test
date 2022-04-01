package com.example.postgesqlherokutest.controller;

import com.example.postgesqlherokutest.model.Anime;
import com.example.postgesqlherokutest.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AnimeController {
    @Autowired
    AnimeRepository animeRepository;

    @GetMapping("/animes")
    public ResponseEntity<List<Anime>> getAllAnimes(@RequestParam(required = false) String name) {
        try {
            List<Anime> animes = new ArrayList<Anime>();

            if (name == null)
                animeRepository.findAll().forEach(animes::add);
            else
                animeRepository.findByNameContaining(name).forEach(animes::add);

            if (animes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/animes")
    public ResponseEntity<Anime> createAnime(@RequestBody Anime anime) {
        try {
            Anime _anime = animeRepository
                    .save(new Anime(anime.getName(), anime.getYear(), anime.getGenre()));
            return new ResponseEntity<>(_anime, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/animes")
    public ResponseEntity<HttpStatus> deleteAllAnimes() {
        try {
            animeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
