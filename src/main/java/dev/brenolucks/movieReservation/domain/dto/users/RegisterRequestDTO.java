package dev.brenolucks.movieReservation.domain.dto.users;

import dev.brenolucks.movieReservation.domain.enums.Role;

public record RegisterRequestDTO(String username, String email, String password){
}
