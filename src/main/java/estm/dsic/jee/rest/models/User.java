
package estm.dsic.jee.rest.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
@Entity
@NamedQuery(name="auth",query="SELECT u FROM User u where u.password = :password AND u.login = :login")
@NamedQuery(name="getAll",query = "SELECT u FROM User u")
public class User implements Serializable{

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;
    
    @Column
    private String password;

    @Column
    private boolean isAdmin;
    
    @Column
    private boolean isValide;

    public boolean getisValide() {
     return isValide;
    }

public void setisValide(boolean isValide) {
     this.isValide = isValide;
}

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
         private List<Contact> contacts;

public static long getSerialversionuid() {
     return serialVersionUID;
}

public int getId() {
     return id;
}

public void setId(int id) {
     this.id = id;
}

public String getLogin() {
     return login;
}

public void setLogin(String login) {
     this.login = login;
}

public String getPassword() {
     return password;
}

public void setPassword(String password) {
     this.password = password;
}

public boolean isAdmin() {
     return isAdmin;
}

public void setisAdmin(boolean isAdmin) {
     this.isAdmin = isAdmin;
}

public List<Contact> getContacts() {
     return contacts;
}

public void setContacts(List<Contact> contacts) {
     this.contacts = contacts;
}



}