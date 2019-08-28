package truespot.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import truespot.model.Role;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserDTO {

    private Long id;
    private Set<Role> roles = new HashSet<>();
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String pseudo;
    private String password;
    private String email;
    private String phoneNumber;

}