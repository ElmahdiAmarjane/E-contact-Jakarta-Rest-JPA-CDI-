package estm.dsic.jee.rest.dal;

import java.util.Collections;
import java.util.List;

import estm.dsic.jee.rest.models.Contact;
import estm.dsic.jee.rest.models.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext; 
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Named
@RequestScoped
@Transactional
public class ContactDao {
     
    @PersistenceContext(name="db_contacts")
       private EntityManager em;

     
   public boolean create(Contact c) {
       try {
         em.persist(c);
         System.out.println(c.getNom() + c.getUser().getId());
         return true;
      } catch (Exception e) {
         System.out.println("Error creating new contact: " + e);
         return false; 
      }    
        
   }
    public List<Contact> getAll(User u) {
     try {
        TypedQuery<Contact> query = em.createNamedQuery("getAllByUserId", Contact.class);
        query.setParameter("userId", u.getId());
        return query.getResultList();
    } catch (Exception e) {
        System.err.println("Error fetching contacts for user with ID " + u.getId() + ": " + e.getMessage());
        return null; // Retourner une liste vide en cas d'erreur
    }
   }
   public boolean remove(Contact c) {
      try {
        Contact cc =  em.find(Contact.class, c.getId());
        em.remove(cc);
        return true;

      } catch (Exception e) {
         System.err.println(e);
         return false;
      }
   }

   public boolean update(Contact contact) {
      try {
        Contact c =  em.find(Contact.class, contact.getId());
        c.setTele(contact.getTele());
        c.setAddress(contact.getAddress());
        c.setEmail(contact.getEmail());
        c.setNom(contact.getNom());
        return true;

      } catch (Exception e) {
         System.err.println(e);
         return false;
      }
   }
    
   public int nbrContacts(User user) {
    try {
        int nbr = ((Number) em.createNamedQuery("getNbrContacts")
                             .setParameter("userId", user.getId())
                             .getSingleResult()).intValue();
                             System.out.println("id user contacts : "+nbr);
        return nbr;
    } catch (NoResultException e) {
      System.out.println("No resul nbr contact");
        return 0;
    } catch (Exception e) {
        // Handle other exceptions
        System.out.println(e);
        return 0;
    }
}


}
