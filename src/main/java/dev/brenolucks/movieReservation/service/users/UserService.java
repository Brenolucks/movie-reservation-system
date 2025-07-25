package dev.brenolucks.movieReservation.service.users;

import dev.brenolucks.movieReservation.domain.dto.users.*;
import dev.brenolucks.movieReservation.domain.enums.Role;

public interface UserService {
    ResponseRegisterDTO registerUser(RegisterRequestDTO registerRequestDTO);
    ResponseLoginDTO loginUser(LoginRequestDTO loginRequestDTO);
    String promoteUser(PromoteUserDTO promoteUserDTO);
}
