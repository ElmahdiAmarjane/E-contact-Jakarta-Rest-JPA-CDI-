package estm.dsic.jee.rest.services;

import java.io.Serializable;

import estm.dsic.jee.rest.dal.UserDao;
import estm.dsic.jee.rest.models.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named
@RequestScoped
public class ImplUserServices implements IUserServices,Serializable{
       @Inject 
        UserDao userDao;
    @Override
    public boolean create(User u) {
        return userDao.create(u);
    }
    
}
