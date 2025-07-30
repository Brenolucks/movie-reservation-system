package dev.brenolucks.movieReservation.repository.movie;

import dev.brenolucks.movieReservation.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
