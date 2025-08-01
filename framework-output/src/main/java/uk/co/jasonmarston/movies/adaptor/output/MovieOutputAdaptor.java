package uk.co.jasonmarston.movies.adaptor.output;

import java.util.UUID;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uk.co.jasonmarston.movies.adaptor.output.data.MovieData;
import uk.co.jasonmarston.movies.adaptor.output.repository.MovieRepository;
import uk.co.jasonmarston.movies.entity.Movie;
import uk.co.jasonmarston.movies.output.port.MovieOutputPort;

@ApplicationScoped
public class MovieOutputAdaptor implements MovieOutputPort {
    @Inject
    private MovieRepository movieRepository;

    @Override
    public Uni<Movie> createMovie(final Movie movie) {
        return movieRepository
            .createMovie(MovieData.buildMovieDataFrom(movie))
            .onItem()
            .transform(MovieData::buildMovieFrom);
    }

    @Override
    public Uni<Movie> readMovie(final UUID id) {
        return movieRepository
            .readMovie(id)
            .onItem()
            .transform(MovieData::buildMovieFrom);
    }

    @Override
    public Uni<Movie> updateMovie(final Movie movie) {
        return movieRepository
            .updateMovie(MovieData.buildMovieDataFrom(movie))
            .onItem()
            .transform(MovieData::buildMovieFrom);
    }

    @Override
    public Uni<Boolean> deleteMovie(final UUID id) {
        return movieRepository
            .deleteMovie(id);
    }
}
