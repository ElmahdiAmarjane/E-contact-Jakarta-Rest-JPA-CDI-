package estm.dsic.jee.rest.controllers;

import estm.dsic.jee.rest.business.IUserServices;
import estm.dsic.jee.rest.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class AuthController {
    
    @Inject
        IUserServices userServices;

    @Path("/signup")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean signup(User u){
        return userServices.create(u);
    }

    @Path("/signin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User signin(User u){
       return  userServices.auth(u);
    }
}
