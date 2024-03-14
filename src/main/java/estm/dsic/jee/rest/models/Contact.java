package estm.dsic.jee.rest.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "create", query = "INSERT INTO Contact (nom, tele, email, Address, user_id) VALUES (:nom, :tele, :email, :address, :userId)")
@NamedQuery(name = "getAllByUserId", query = "SELECT c FROM Contact c WHERE c.user.id = :userId")
public class Contact implements Serializable{

     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @Column 
     private String nom ;

     @Column
     private String tele;

     @Column
     private String email;


     @Column
     private String Address;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public User getUser() {
        return user;
    }

    // public void setUser(User user) {
    //     this.user = user;
    // }
    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            this.user.setId(user.getId());  // Assuming getId() returns the user_id
        } 
    }
    

     
}
