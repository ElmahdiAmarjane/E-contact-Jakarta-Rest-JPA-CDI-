package estm.dsic.jee.rest.business;

import java.util.List;

import estm.dsic.jee.rest.models.User;

public interface IUserServices {
       
         boolean create(User u);
         User auth(User u);
         User find(User u);
         List<User> getAll();

}