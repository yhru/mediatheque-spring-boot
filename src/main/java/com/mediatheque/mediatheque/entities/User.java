package com.mediatheque.mediatheque.entities;

import javax.persistence.*;

@Entity(name = "User") // on map notre class pour dire que c'est une entité
@Table(name = "user")
public class User {

    //Création des properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    //------------------------------------------//
    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String name;
    //------------------------------------------//
    @Column(
            name = "isAdmin",
            columnDefinition = "boolean" //user ou gestionnaire
    )
    private boolean isAdmin;

    //Constructeur

    public User(String name, boolean isAdmin) {
//        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public User(){}


    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    //ToString


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
