package uk.co.jasonmarston.movies.output.adaptor;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import uk.co.jasonmarston.movies.output.data.MovieData;
import uk.co.jasonmarston.movies.output.repository.MovieRepository;
import uk.co.jasonmarston.movies.domain.entity.Movie;
import uk.co.jasonmarston.movies.output.port.MovieOutputPort;

import java.util.UUID;

@ApplicationScoped
public class MovieOutputAdaptor implements MovieOutputPort {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Inject
    private MovieRepository movieRepository;

    @Override
    public Uni<Movie> createMovie(final Movie movie) {
        return movieRepository
            .createMovie(MODEL_MAPPER.map(movie, MovieData.class))
            .onItem()
            .transform(movieData -> MODEL_MAPPER.map(movieData, Movie.class));
    }

    @Override
    public Uni<Movie> readMovie(final UUID id) {
        return movieRepository
            .readMovie(id)
            .onItem()
            .transform(movie -> MODEL_MAPPER.map(movie, Movie.class));
    }

    @Override
    public Uni<Movie> updateMovie(final Movie movie) {
        return movieRepository
            .updateMovie(MODEL_MAPPER.map(movie, MovieData.class))
            .onItem()
            .transform(movieData -> MODEL_MAPPER.map(movieData, Movie.class));
    }

    @Override
    public Uni<Boolean> deleteMovie(final UUID id) {
        return movieRepository
            .deleteMovie(id);
    }
}
