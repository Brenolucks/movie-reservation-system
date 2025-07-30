package dev.brenolucks.movieReservation.controller;

import dev.brenolucks.movieReservation.domain.dto.users.*;
import dev.brenolucks.movieReservation.service.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
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

    @PatchMapping("/promote-user")
    public ResponseEntity<String> promoteUser(@RequestBody PromoteUserDTO promoteUserDTO) {
        if(promoteUserDTO.role() == null) {
            throw new IllegalArgumentException("You need pass a valid role, like 'ADMIN' or 'USER'.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userService.promoteUser(promoteUserDTO));
    }

}
