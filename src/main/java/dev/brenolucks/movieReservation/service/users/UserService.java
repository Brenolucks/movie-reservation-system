package dev.brenolucks.movieReservation.service.users;

import dev.brenolucks.movieReservation.domain.dto.users.LoginRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.users.RegisterRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.users.ResponseLoginDTO;
import dev.brenolucks.movieReservation.domain.dto.users.ResponseRegisterDTO;

public interface UserService {
    ResponseRegisterDTO registerUser(RegisterRequestDTO registerRequestDTO);
    ResponseLoginDTO loginUser(LoginRequestDTO loginRequestDTO);
}
