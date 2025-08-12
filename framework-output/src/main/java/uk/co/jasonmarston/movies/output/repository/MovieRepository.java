package uk.co.jasonmarston.movies.output.repository;

import io.smallrye.mutiny.Uni;
import uk.co.jasonmarston.movies.output.data.MovieData;

import java.util.UUID;

public interface MovieRepository {
    Uni<MovieData> createMovie(MovieData movieData);
    Uni<MovieData> readMovie(UUID id);
    Uni<MovieData> updateMovie(MovieData movieData);
    Uni<Boolean> deleteMovie(UUID id);
}