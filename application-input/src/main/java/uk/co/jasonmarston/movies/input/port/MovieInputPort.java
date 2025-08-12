package uk.co.jasonmarston.movies.input.port;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uk.co.jasonmarston.movies.domain.entity.Movie;
import uk.co.jasonmarston.movies.output.port.MovieOutputPort;
import uk.co.jasonmarston.movies.input.usecase.MovieUseCase;

import java.util.UUID;

@ApplicationScoped
public class MovieInputPort implements MovieUseCase {
    @Inject
    private MovieOutputPort movieOutputPort;

    @Override
    public Uni<Movie> createMovie(final Movie movie) {
        return movieOutputPort.createMovie(movie);
    }

    @Override
    public Uni<Movie> readMovie(final UUID id) {
        return movieOutputPort.readMovie(id);
    }

    @Override
    public Uni<Movie> updateMovie(final Movie movie) {
        return movieOutputPort.updateMovie(movie);
    }

    @Override
    public Uni<Boolean> deleteMovie(final UUID id) {
        return movieOutputPort.deleteMovie(id);
    }
}
