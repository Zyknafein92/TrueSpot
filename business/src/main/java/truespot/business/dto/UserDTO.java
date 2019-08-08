package truespot.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import truespot.model.Role;
import truespot.model.RoleName;
import truespot.model.User;


import java.util.*;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserDTO {

    private Long id;
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