package truespot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Users", schema= "public")
public class Users {


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
}
