package truespot.business.dto;

import lombok.Data;


import java.util.List;

@Data
public class UserDTO {

    private long id;
    private List<TopoDTO> topo;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String pseudo;
    private String password;
    private String email;
    private String phoneNumber;
    private Boolean isAdmin;

}
