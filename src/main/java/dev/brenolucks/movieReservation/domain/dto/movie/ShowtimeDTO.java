package dev.brenolucks.movieReservation.domain.dto.movie;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record ShowtimeDTO(@JsonFormat(pattern = "yyyy-MM-dd") LocalDate date,
                          @JsonFormat(pattern = "HH:mm") LocalTime hour,
                          Long movieId) {
}
