package truespot.business.contract;


import truespot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserManager {

    List<User> findAllUser();

    Optional<User> getUser(Long id);

    User saveUser(User user);

//    User findByPseudo(String pseudo);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}
