package estm.dsic.jee.rest.controllers;

import java.util.List;

import estm.dsic.jee.rest.business.IContactServices;
import estm.dsic.jee.rest.models.Contact;
import estm.dsic.jee.rest.models.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/contact")
public class ContactController {
    @Inject
      private IContactServices contactServices;

   @Path("/create")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public boolean create(Contact c){
         return contactServices.create(c);
   }

   @Path("/all")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public List<Contact> getAll(User u){
         return contactServices.getAll(u);
   }

   @Path("/remove")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public boolean remove(Contact c){
         return contactServices.remove(c);
   }
   @Path("/update")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public boolean update(Contact c){
         return contactServices.update(c);
   }
   @Path("/nbrcontacts")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public int nbrContacts(User user){
      System.out.println("id user con controller : "+user.getId());
         return contactServices.nbrContacts(user);
   }

}
