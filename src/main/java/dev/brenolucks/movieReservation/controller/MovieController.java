package dev.brenolucks.movieReservation.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.brenolucks.movieReservation.domain.dto.movie.AllMoviesResponseDTO;
import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;
import dev.brenolucks.movieReservation.service.movie.MovieService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/all-movies")
    public ResponseEntity<List<AllMoviesResponseDTO>> allMovies(@RequestParam @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<AllMoviesResponseDTO>());
    }

//    @GetMapping("/by-genre")
//    public ResponseEntity<String> getMovieByGenre(@RequestParam String genre) {
//        return ResponseEntity.status(HttpStatus.OK).body("Movies with this genres");
//    }
}
