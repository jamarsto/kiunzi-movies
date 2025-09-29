package uk.co.jasonmarston.movies.output.repository.impl;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import uk.co.jasonmarston.movies.output.data.MovieData;
import uk.co.jasonmarston.movies.output.repository.MovieRepository;

import java.time.Duration;
import java.util.UUID;

@ApplicationScoped
public class SimpleMovieRepository implements
    MovieRepository,
    PanacheRepositoryBase<MovieData,UUID>
{
    @Override
    public Uni<MovieData> createMovie(final MovieData movieData) {
        return Panache
            .withTransaction(() -> persist(movieData))
            .ifNoItem()
            .after(Duration.ofMillis(10000))
            .fail()
            .onFailure()
            .transform(IllegalStateException::new);
    }

    @Override
    public Uni<MovieData> readMovie(final UUID id) {
        return Panache
            .withTransaction(() -> findById(id));
    }

    @Override
    public Uni<MovieData> updateMovie(final MovieData movieData) {
        return Panache
            .withTransaction(() -> findById(movieData.getId())
                .onItem()
                .ifNotNull()
                .transform(item -> {
                    if(item.getVersion().equals(movieData.getVersion())) {
                        return movieData;
                    }
                    return null;
                })
                .onFailure()
                .recoverWithNull()
            );
    }

    @Override
    public Uni<Boolean> deleteMovie(final UUID id) {
        return Panache
            .withTransaction(() -> deleteById(id)
                .onItem()
                .transform(item -> {
                    if(Boolean.TRUE.equals(item)) {
                        return Boolean.TRUE;
                    }
                    return null;
                })
                .onFailure()
                .recoverWithNull()
            );
    }
}
