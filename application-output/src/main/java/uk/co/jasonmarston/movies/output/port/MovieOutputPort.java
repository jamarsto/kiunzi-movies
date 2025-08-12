package uk.co.jasonmarston.movies.output.port;

import io.smallrye.mutiny.Uni;
import uk.co.jasonmarston.movies.domain.entity.Movie;

import java.util.UUID;

public interface MovieOutputPort {
    Uni<Movie> createMovie(final Movie movie);
    Uni<Movie> readMovie(final UUID id);
    Uni<Movie> updateMovie(final Movie movie);
    Uni<Boolean> deleteMovie(final UUID id);
}
