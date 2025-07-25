package dev.brenolucks.movieReservation.controller;

import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Movie Added with Success!");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("Movie Updated with Success!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMovie(@RequestParam int movieID) {
        return ResponseEntity.status(HttpStatus.OK).body("Movie Deleted with Success!");
    }

    @GetMapping("/by-genre")
    public ResponseEntity<String> getMovieByGenre(@RequestParam String genre) {
        return ResponseEntity.status(HttpStatus.OK).body("Movies with this genres");
    }
}
