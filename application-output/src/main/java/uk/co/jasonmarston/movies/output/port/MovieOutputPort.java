package uk.co.jasonmarston.movies.output.port;

import java.util.UUID;

import io.smallrye.mutiny.Uni;
import uk.co.jasonmarston.movies.entity.Movie;

public interface MovieOutputPort {
    Uni<Movie> createMovie(final Movie movie);
    Uni<Movie> readMovie(final UUID id);
    Uni<Movie> updateMovie(final Movie movie);
    Uni<Boolean> deleteMovie(final UUID id);
}
