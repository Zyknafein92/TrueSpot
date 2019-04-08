package truespot.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="Users", schema= "public")
public class Users implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_id")
    private long id;


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

    protected Users(){}

    public Users(String name, String realName, int age, String gender, String pseudo, String password, String email, String phoneNumber, Boolean admin) {
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
