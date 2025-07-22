package dev.brenolucks.movieReservation.controller;

import dev.brenolucks.movieReservation.domain.dto.users.LoginRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.users.RegisterRequestDTO;
import dev.brenolucks.movieReservation.domain.dto.users.ResponseLoginDTO;
import dev.brenolucks.movieReservation.domain.dto.users.ResponseRegisterDTO;
import dev.brenolucks.movieReservation.service.users.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterDTO> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        var res = userService.registerUser(registerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        var res = userService.loginUser(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
