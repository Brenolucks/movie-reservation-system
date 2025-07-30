package dev.brenolucks.movieReservation.service.users;

import dev.brenolucks.movieReservation.domain.dto.users.*;

public interface IUserService {
    ResponseRegisterDTO registerUser(RegisterRequestDTO registerRequestDTO);
    ResponseLoginDTO loginUser(LoginRequestDTO loginRequestDTO);
    String promoteUser(PromoteUserDTO promoteUserDTO);
}
