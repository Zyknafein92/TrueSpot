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

   // String login (User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}
