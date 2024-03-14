package estm.dsic.jee.rest.dal;

import java.util.List;

import estm.dsic.jee.rest.models.User;
import jakarta.enterprise.context.RequestScoped;
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

   public boolean create(User u) {
      try {
         em.persist(u);
         return true;
      } catch (Exception e) {
         System.out.println("Error creating new User: " + e);
         return false;
      }
   }

   public User auth(User u) {
      try {

         User user = (User) em.createNamedQuery("auth")
               .setParameter("password", u.getPassword())
               .setParameter("login", u.getLogin())
               .getSingleResult();
         return user;
      } catch (Exception e) {
         System.err.println(e);
         return null;
      }

   }

   public User find(User u) {
      return em.find(User.class, u.getId());
   }

   public List<User> getAll() {
      try {
         return (List<User>) em.createNamedQuery("getAll").getResultList();

      } catch (Exception e) {
         System.err.println(e);
         return null;
      }
   }
   public boolean update(User user) {
      try {
        User u =  em.find(User.class, user.getId());
        u.setLogin(user.getLogin());
        u.setisValide(user.getisValide());
        return true;

      } catch (Exception e) {
         System.err.println(e);
         return false;
      }
   }
   
   public boolean remove(User user) {
      try {
        User u =  em.find(User.class, user.getId());
        em.remove(u);
        return true;

      } catch (Exception e) {
         System.err.println(e);
         return false;
      }
   }


}
