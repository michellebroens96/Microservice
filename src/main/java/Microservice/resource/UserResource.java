package Microservice.resource;

import Microservice.dto.UserDTO;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.gson.GsonFactory;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Path("user")
public class UserResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(UserDTO userDTO) {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        GenericUrl url = new GenericUrl("http://local:8080/user");

        try {
            JsonHttpContent content = new JsonHttpContent(GsonFactory.getDefaultInstance(), userDTO);
            HttpRequest request = requestFactory.buildPostRequest(url, content);
            HttpResponse response = request.execute();
            if(!response.isSuccessStatusCode()) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }
        catch(IOException e) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        return Response.ok(userDTO).build();
    }
}
