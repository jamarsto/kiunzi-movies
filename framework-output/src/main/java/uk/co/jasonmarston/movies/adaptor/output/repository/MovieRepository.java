package uk.co.jasonmarston.movies.adaptor.output.repository;

import java.util.UUID;

import io.smallrye.mutiny.Uni;
import uk.co.jasonmarston.movies.adaptor.output.data.MovieData;

public interface MovieRepository {

	Uni<MovieData> createMovie(MovieData movieData);

	Uni<MovieData> readMovie(UUID id);

	Uni<MovieData> updateMovie(MovieData movieData);

	Uni<Boolean> deleteMovie(UUID id);

}