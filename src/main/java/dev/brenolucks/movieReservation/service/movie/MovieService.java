package dev.brenolucks.movieReservation.service.movie;

import dev.brenolucks.movieReservation.domain.Movie;
import dev.brenolucks.movieReservation.domain.dto.movie.MovieRequestDTO;
import dev.brenolucks.movieReservation.domain.mappers.movie.MovieMapper;
import dev.brenolucks.movieReservation.domain.mappers.movie.ShowtimeMapper;
import dev.brenolucks.movieReservation.repository.movie.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService{
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final ShowtimeMapper showtimeMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper, ShowtimeMapper showtimeMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.showtimeMapper = showtimeMapper;
    }

    @Override
    public String addMovie(MovieRequestDTO movieRequestDTO) {
        movieRepository.save(movieMapper.toMovie(movieRequestDTO));
        return "Movie added with success!";
    }

    @Override
    public String updateMovie(Long movieID, MovieRequestDTO movieRequestDTO) {
        Movie movie = movieRepository.findById(movieID).orElseThrow(() -> new RuntimeException("Movie not exist"));

        if (movieRequestDTO.title() != null) { movie.setTitle(movieRequestDTO.title()); }
        if (movieRequestDTO.description() != null) { movie.setDescription(movieRequestDTO.description()); }
        if (movieRequestDTO.showtime() != null) { movie.setShowtime(showtimeMapper.toShowtime(movieRequestDTO.showtime())); }

        movieRepository.save(movie);

        return "Movie updated with success!";
    }

    @Override
    public String deleteMovie(Long movieID) {
        movieRepository.deleteById(movieID);
        return "Movie deleted with success!";
    }
}
