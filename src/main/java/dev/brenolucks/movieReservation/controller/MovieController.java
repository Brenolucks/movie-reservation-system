package dev.brenolucks.movieReservation.controller;

import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;
import dev.brenolucks.movieReservation.service.movie.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movieRequestDTO));
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateMovie(@RequestParam Long movieID, @RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(movieID, movieRequestDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMovie(@RequestParam Long movieID) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.deleteMovie(movieID));
    }

//    @GetMapping("/by-genre")
//    public ResponseEntity<String> getMovieByGenre(@RequestParam String genre) {
//        return ResponseEntity.status(HttpStatus.OK).body("Movies with this genres");
//    }
}
