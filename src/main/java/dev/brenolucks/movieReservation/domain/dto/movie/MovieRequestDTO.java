package dev.brenolucks.movieReservation.domain.dto.movie;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.brenolucks.movieReservation.domain.MovieImage;
import dev.brenolucks.movieReservation.domain.Reserve;
import dev.brenolucks.movieReservation.domain.Showtime;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record MovieRequestDTO(String title, String description, String genre, MovieImageDTO movieImage,
                              @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dateBegin,
                              @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dateEnd, BigDecimal price,
                              List<ShowtimeDTO> showtime, List<ReserveDTO> reserves
                              ) {
}
