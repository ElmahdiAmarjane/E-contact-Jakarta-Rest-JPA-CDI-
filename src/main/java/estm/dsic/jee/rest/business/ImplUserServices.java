package estm.dsic.jee.rest.business;

import java.io.Serializable;
import java.util.List;

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
    @Override
    public User auth(User u) {
         return userDao.auth(u);
    }
    @Override
    public User find(User u) {
          return userDao.find(u);
    }
    @Override
    public List<User> getAll() {
         return userDao.getAll();
    }
    
}
