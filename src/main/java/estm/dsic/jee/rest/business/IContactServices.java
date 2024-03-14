package estm.dsic.jee.rest.business;

import java.util.List;

import estm.dsic.jee.rest.models.Contact;
import estm.dsic.jee.rest.models.User;

public interface IContactServices {
    
     boolean create(Contact c);
     List<Contact> getAll(User u);
     boolean remove(Contact c);
     boolean update(Contact c);
     int nbrContacts(User u);
}
