package dev.brenolucks.movieReservation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_movie")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String genre;
    //private String posterImage;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBegin;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateEnd;
    private BigDecimal price;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserve> reserves;
}
