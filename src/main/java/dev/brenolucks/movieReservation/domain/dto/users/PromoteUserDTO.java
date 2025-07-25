package dev.brenolucks.movieReservation.domain.dto.users;

import dev.brenolucks.movieReservation.domain.enums.Role;

public record PromoteUserDTO(String email, Role role) {
}
