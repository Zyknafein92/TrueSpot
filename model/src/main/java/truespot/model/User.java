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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_id")
    private long id;

    @OneToMany
    private List<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Topo> topo;

    @Column(name="name")
    private String name;

    @Column(name="real_name")
    private String realName;

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

    public User(String name, String realName, int age, String gender, String pseudo, String password, String email, String phoneNumber, Boolean admin) {
        this.name = name;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
    }
}
