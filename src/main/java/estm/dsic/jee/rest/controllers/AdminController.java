package estm.dsic.jee.rest.controllers;

import java.util.List;

import estm.dsic.jee.rest.business.IUserServices;
import estm.dsic.jee.rest.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("/admin")
public class AdminController {
     
    @Inject
       IUserServices userServices;

    @Path("/findById")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User findById(User u ){
         return userServices.find(u);
    }

    @Path("/all")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll(){
         return userServices.getAll();
    }





}
