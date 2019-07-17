package truespot.business.dto;

import lombok.Data;
import truespot.model.Role;
import truespot.model.RoleName;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private long id;
    private List<TopoDTO> topo;
    private Set<Role> roles = new HashSet<>();
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String pseudo;
    private String password;
    private String email;
    private String phoneNumber;
}
