package truespot.business.contract;


import truespot.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersManager {

    List<Users> findAllUser();

    Optional<Users> getUser(Long id);

    Users saveUser(Users user);

    void updateUser(Long id, Users user);

    void deleteUser(Long id);

}
