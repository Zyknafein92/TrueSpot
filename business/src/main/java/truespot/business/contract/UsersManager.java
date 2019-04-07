package truespot.business.contract;


import truespot.model.Users;

import java.util.List;

public interface UsersManager {

    List<Users> findAllUser(Users user);

    Users createUser(Users user);

    void updateUser(Users user);

    void deleteUser(Long id);

}
