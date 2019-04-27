package truespot.business.dto;

import lombok.Data;


import java.util.List;

@Data
public class UserDTO {

    private long id;
    private List<TopoDTO> topo;
    private String name;
    private String realName;
    private int age;
    private String gender;
    private String pseudo;
    private String password;
    private String email;
    private String phoneNumber;

}
