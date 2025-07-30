package dev.brenolucks.movieReservation.domain.mappers.movie;

import dev.brenolucks.movieReservation.domain.Showtime;
import dev.brenolucks.movieReservation.domain.dto.movie.ShowtimeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShowtimeMapper {
    ShowtimeMapper INSTANCE = Mappers.getMapper(ShowtimeMapper.class);

    List<Showtime> toShowtime(List<ShowtimeDTO> showtimeDTOS);
}
