package dev.brenolucks.movieReservation.domain.enums;

public enum Role {
    ADMIN,
    USER;

    public String toAuthority() {
        return "ROLE_" + this.name();
    }
}
