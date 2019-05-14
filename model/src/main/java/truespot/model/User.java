package truespot.model;


import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "User")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen")
@Getter
@Setter
@Entity
@Table(name="User", schema= "public")
public class User implements Serializable {

 //todo : ajouter 2 arraylist : demande de pret et prêté a pour le prêt de topo.


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;

    @OneToMany()
    private List<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Topo> topo;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="gender")
    private String gender;

    @Column(name="pseudo")
    private String pseudo;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="isadmin")
    private Boolean admin;

    public User(){}

    public User(String firstName, String lastName, int age, String gender, String pseudo, String password, String email, String phoneNumber, Boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }
}
