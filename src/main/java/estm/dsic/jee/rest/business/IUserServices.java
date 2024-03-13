package estm.dsic.jee.rest.business;

import estm.dsic.jee.rest.models.User;

public interface IUserServices {
       
         boolean create(User u);
         User auth(User u);

}