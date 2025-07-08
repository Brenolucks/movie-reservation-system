package dev.brenolucks.movieReservation.repository.users;

import dev.brenolucks.movieReservation.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public Optional<Users> findByUsername(String username);
}
