package truespot.business.contract;


import truespot.business.dto.UserDTO;
import truespot.model.User;

import java.util.List;

public interface UserManager {

    List<User> findAllUser();

    UserDTO getUser(Long id);

    User saveUser(UserDTO userDTO);

    User findByPseudo(String pseudo);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}
