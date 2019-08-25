package truespot.business.contract;


import org.springframework.http.ResponseEntity;
import truespot.business.dto.UserDTO;
import truespot.model.User;

import java.util.List;

public interface UserManager {

    List<User> findAllUser();

    UserDTO getUser(Long id);

    ResponseEntity<Object> saveUser(UserDTO userDTO);

    User findByPseudo(String pseudo);

    void updateUser(UserDTO userDTO);

    void updateUserRole(UserDTO userDTO);

    void deleteUser(Long id);

}
