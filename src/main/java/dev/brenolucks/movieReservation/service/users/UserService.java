package dev.brenolucks.movieReservation.service.users;

import dev.brenolucks.movieReservation.domain.Users;
import dev.brenolucks.movieReservation.domain.dto.users.*;
import dev.brenolucks.movieReservation.domain.enums.Role;
import dev.brenolucks.movieReservation.domain.mappers.users.UsersMapper;
import dev.brenolucks.movieReservation.repository.users.UsersRepository;
import dev.brenolucks.movieReservation.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersMapper usersMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, UsersMapper usersMapper,
                       AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.usersMapper = usersMapper;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public ResponseRegisterDTO registerUser(RegisterRequestDTO registerRequestDTO) {
        usersRepository.findByEmail(registerRequestDTO.email()).ifPresent(users -> {
            throw new RuntimeException("User already exists!");
        });

        var passwordEncrypted = passwordEncoder.encode(registerRequestDTO.password());

        var newUser = usersMapper.toEntityWithEncryptedPassword(registerRequestDTO.username(), registerRequestDTO.email(), passwordEncrypted);
        newUser.setRole(Role.USER);
        usersRepository.save(newUser);

        return new ResponseRegisterDTO(newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public ResponseLoginDTO loginUser(LoginRequestDTO loginRequestDTO) {
        var data = usersRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("Users not exists!"));

        var user = new UsernamePasswordAuthenticationToken(loginRequestDTO.username(), loginRequestDTO.password());

        var userAuthenticated = authenticationManager.authenticate(user);
        var token = jwtUtils.generateToken((Users) userAuthenticated.getPrincipal());

        return new ResponseLoginDTO(loginRequestDTO.email(), token);
    }

    @Override
    public String promoteUser(PromoteUserDTO promoteUserDTO) {
        var user = usersRepository.findByEmail(promoteUserDTO.email()).orElseThrow(() -> new RuntimeException("User not exist"));
        user.setRole(promoteUserDTO.role());
        usersRepository.save(user);

        return "User promoted with success";
    }
}
