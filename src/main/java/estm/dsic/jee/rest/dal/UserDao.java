package estm.dsic.jee.rest.dal;

import estm.dsic.jee.rest.models.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named
@RequestScoped
@Transactional
public class UserDao {
  
      @PersistenceContext(name = "db_contacts")
       private EntityManager em;

       public boolean create(User u){
        try {
            em.persist(u);
            return true;
        } catch (Exception e) {
            System.out.println("Error creating new User: "+e);
            return false;
        }
          
           
       }


}