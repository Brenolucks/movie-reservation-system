package dev.brenolucks.movieReservation.service.movie;

import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;

public interface IMovieService {
    String addMovie(MovieRequestDTO movieRequestDTO);
    String updateMovie(Long MovieID, MovieRequestDTO movieRequestDTO);
    String deleteMovie(Long idMovie);
}
