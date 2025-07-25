package dev.brenolucks.movieReservation.domain.mappers.users;

import dev.brenolucks.movieReservation.domain.Users;
import dev.brenolucks.movieReservation.domain.dto.users.RegisterRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.users.ResponseRegisterDTO;
import dev.brenolucks.movieReservation.domain.enums.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    ResponseRegisterDTO toResponseDTO(Users users);
    Users toEntityByRegisterDTO(RegisterRequestDTO registerRequestDTO);
    Users toEntityWithEncryptedPassword(String username, String email, String password);
    Users toEntityPromoteUser(Role role);
}
