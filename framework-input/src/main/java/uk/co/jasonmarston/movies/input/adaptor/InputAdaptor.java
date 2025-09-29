package uk.co.jasonmarston.movies.input.adaptor;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.modelmapper.ModelMapper;
import uk.co.jasonmarston.movies.domain.entity.Movie;
import uk.co.jasonmarston.movies.input.bean.CreateMovieBean;
import uk.co.jasonmarston.movies.input.bean.MovieBean;
import uk.co.jasonmarston.movies.input.bean.UpdateMovieBean;
import uk.co.jasonmarston.movies.input.usecase.MovieUseCase;

import java.util.UUID;

@ApplicationScoped
public class InputAdaptor {
    private static final Status CREATED = Status.CREATED;
    private static final Response NOT_FOUND = Response
        .status(Status.NOT_FOUND)
        .build();
    private static final Response OK = Response
        .ok()
        .build();
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    @Inject
    private MovieUseCase movieUseCase;

    public Uni<Response> createMovie(
        final CreateMovieBean createMovieBean
    ) {
        return movieUseCase
            .createMovie(MODEL_MAPPER.map(createMovieBean, Movie.class))
            .onItem()
            .transform(movie -> MODEL_MAPPER.map(movie, MovieBean.class))
            .onItem()
            .transform(movieBean -> Response
                .ok(movieBean)
                .status(CREATED)
                .build()
            )
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }

    public Uni<Response> readMovie(
        final UUID id
    ) {
        return movieUseCase
            .readMovie(id)
            .onItem()
            .transform(movie -> MODEL_MAPPER.map(movie, MovieBean.class))
            .onItem()
            .transform(movieBean -> Response
                .ok(movieBean)
                .build()
            )
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }

    public Uni<Response> updateMovie(
        final UpdateMovieBean updateMovieBean
    ) {
        return movieUseCase
            .updateMovie(MODEL_MAPPER.map(updateMovieBean, Movie.class))
            .onItem()
            .transform(movie -> MODEL_MAPPER.map(movie, MovieBean.class))
            .onItem()
            .transform(movieBean -> Response
                .ok(movieBean)
                .build()
            )
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }

    public Uni<Response> deleteMovie(
        final UUID id
    ) {
        return movieUseCase
            .deleteMovie(id)
            .onItem()
            .transform(result -> result ? OK : NOT_FOUND)
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }
}
