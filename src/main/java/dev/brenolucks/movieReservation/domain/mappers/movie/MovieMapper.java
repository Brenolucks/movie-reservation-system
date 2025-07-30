package dev.brenolucks.movieReservation.domain.mappers.movie;

import dev.brenolucks.movieReservation.domain.Movie;
import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.movie.MovieResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toMovie(MovieRequestDTO movieRequestDTO);
    MovieResponseDTO toResponseDTO(Movie movie);
}
