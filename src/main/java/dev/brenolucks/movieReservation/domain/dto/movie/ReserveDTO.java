package dev.brenolucks.movieReservation.domain.dto.movie;

import java.util.List;

public record ReserveDTO(String clientName,
                         List<String> seats,
                         Long showtimeId ) {
}
