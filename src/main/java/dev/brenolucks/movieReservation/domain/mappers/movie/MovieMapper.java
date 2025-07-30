package dev.brenolucks.movieReservation.domain.mappers.movie;

import dev.brenolucks.movieReservation.domain.Movie;
import dev.brenolucks.movieReservation.domain.Showtime;
import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.movie.MovieResponseDTO;
import dev.brenolucks.movieReservation.domain.dto.movie.ShowtimeDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toMovie(MovieRequestDTO movieRequestDTO);
    MovieResponseDTO toResponseDTO(Movie movie);
    Showtime toShowtime(ShowtimeDTO showtimeDTO);

    @AfterMapping
    default void linkShowtimesToMovie(@MappingTarget Movie movie) {
        if (movie.getShowtime() != null) {
            for (Showtime showtime : movie.getShowtime()) {
                showtime.setMovie(movie); // Set the back-reference
            }
        }
    }
}
