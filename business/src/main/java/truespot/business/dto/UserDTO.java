package truespot.business.dto;

import lombok.Data;
import truespot.model.Role;


import java.util.List;

@Data
public class UserDTO {

    private long id;
    private List<TopoDTO> topo;
    private List<Role> roles;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String pseudo;
    private String password;
    private String email;
    private String phoneNumber;


}
