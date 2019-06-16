package Microservice.resource;

import nl.tbc.rekeningrijden.resources.BaseResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource extends BaseResource {

    @GET
    public Response getTest() {
        String test = "Rest working :D";
        return Response.ok(test).build();
    }
}
