package dev.brenolucks.movieReservation.repository.movie;

import dev.brenolucks.movieReservation.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findFirstByTitle(String title);
}
