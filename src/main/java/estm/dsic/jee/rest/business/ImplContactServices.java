package estm.dsic.jee.rest.business;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.rest.dal.ContactDao;
import estm.dsic.jee.rest.models.Contact;
import estm.dsic.jee.rest.models.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named
@RequestScoped 
public class ImplContactServices implements IContactServices,Serializable{
    @Inject
      ContactDao contactDao;



    @Override
    public boolean create(Contact c) {
        return contactDao.create(c);
    }



    @Override
    public List<Contact> getAll(User u) {
      return contactDao.getAll(u);
    }



    @Override
    public boolean remove(Contact c) {
          return contactDao.remove(c);
    }



    @Override
    public boolean update(Contact c) {
          return contactDao.update(c);
    }



    @Override
    public int nbrContacts(User u) {
         return contactDao.nbrContacts(u);
    }
    
    
}
