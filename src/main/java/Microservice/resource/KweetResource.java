package Microservice.resource;

import Microservice.dto.KweetDTO;
import Microservice.model.Kweet;
import Microservice.service.IKweetService;
import lombok.NonNull;
import nl.tbc.rekeningrijden.helper.ModelMapperHelper;
import nl.tbc.rekeningrijden.resources.BaseResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/kweets")
public class KweetResource extends BaseResource {

    @Inject
    private IKweetService kweetService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKweets() {
        return createListResponse(kweetService.getAll(), KweetDTO.class);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKweet(@PathParam("id") Long id) {
        return createSingleResponse(kweetService.get(id), KweetDTO.class);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addKweet(@NonNull KweetDTO tracker) throws Exception {
        kweetService.add(ModelMapperHelper.getModdelMapper().map(tracker, Kweet.class));
        return Response.accepted().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateKweet(@PathParam("id") Long id, @NonNull KweetDTO tracker) throws Exception {
        kweetService.update(ModelMapperHelper.getModdelMapper().map(tracker, Kweet.class));
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKweet(@PathParam("id") Long id) {
        kweetService.delete(id);
        return Response.ok().build();
    }


}
