package uk.co.jasonmarston.movies.input.adaptor;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import uk.co.jasonmarston.movies.input.bean.CreateMovieBean;
import uk.co.jasonmarston.movies.input.bean.UpdateMovieBean;

import java.util.UUID;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/client-api")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@RolesAllowed("user")
public class ClientMovieInputAdaptor {
    @Inject
    private InputAdaptor inputAdaptor;

    @POST
    @Path("/movie")
    public Uni<Response> createMovie(
        final CreateMovieBean createMovieBean
    ) {
        return inputAdaptor.createMovie(createMovieBean);
    }

    @GET
    @Path("/movie/{id}")
    public Uni<Response> readMovie(
        final UUID id
    ) {
        return inputAdaptor.readMovie(id);
    }

    @PUT
    @Path("/movie")
    public Uni<Response> updateMovie(
        final UpdateMovieBean updateMovieBean
    ) {
        return inputAdaptor.updateMovie(updateMovieBean);
    }

    @DELETE
    @Path("/movie/{id}")
    public Uni<Response> deleteMovie(
        final UUID id
    ) {
        return inputAdaptor.deleteMovie(id);
    }
}
