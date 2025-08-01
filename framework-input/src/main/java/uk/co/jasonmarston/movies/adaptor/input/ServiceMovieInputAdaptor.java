package uk.co.jasonmarston.movies.adaptor.input;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import uk.co.jasonmarston.movies.adaptor.input.bean.CreateMovieBean;
import uk.co.jasonmarston.movies.adaptor.input.bean.MovieBean;
import uk.co.jasonmarston.movies.adaptor.input.bean.UpdateMovieBean;
import uk.co.jasonmarston.movies.usecase.MovieUseCase;

import java.util.UUID;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/service-api")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@RolesAllowed({"user", "service"})
public class ServiceMovieInputAdaptor {
    private static final Status CREATED = Status.CREATED;
    private static final Response NOT_FOUND = Response
        .status(Status.NOT_FOUND)
        .build();
    private static final Response OK = Response
        .ok()
        .build();

    @Inject
    private MovieUseCase movieUseCase;

    @POST
    @Path("/movie")
    public Uni<Response> createMovie(
        final CreateMovieBean createMovieBean
    ) {
        return movieUseCase
            .createMovie(CreateMovieBean.buildMovieFrom(createMovieBean))
            .onItem()
            .transform(MovieBean::buildMovieBeanFrom)
            .onItem()
            .transform(movieBean -> Response
                .ok(movieBean)
                .status(CREATED)
                .build()
            )
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }

    @GET
    @Path("/movie/{id}")
    public Uni<Response> readMovie(
        final UUID id
    ) {
        return movieUseCase
            .readMovie(id)
            .onItem()
            .transform(MovieBean::buildMovieBeanFrom)
            .onItem()
            .transform(movieBean -> Response
                .ok(movieBean)
                .build()
            )
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }

    @PUT
    @Path("/movie")
    public Uni<Response> updateMovie(
        final UpdateMovieBean updateMovieBean
    ) {
        return movieUseCase
            .updateMovie(UpdateMovieBean.buildMovieFrom(updateMovieBean))
            .onItem()
            .transform(MovieBean::buildMovieBeanFrom)
            .onItem()
            .transform(movieBean -> Response
                .ok(movieBean)
                .build()
            )
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }

    @DELETE
    @Path("/movie/{id}")
    public Uni<Response> deleteMovie(final UUID id) {
        return movieUseCase
            .deleteMovie(id)
            .onItem()
            .transform(result -> result ? OK : NOT_FOUND)
            .onFailure()
            .recoverWithItem(NOT_FOUND);
    }
}
