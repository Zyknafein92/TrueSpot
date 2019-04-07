package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.UsersManager;
import truespot.model.Users;

import java.util.List;

@Service
public class UsersManagerImpl extends BusinessManagerImpl implements UsersManager {


    @Override
    public List<Users> findAllUser(Users user) {
        return getDaoFactory().getUsersRepository().findAll();
    }

    @Override
    public Users createUser(Users user) {
        return getDaoFactory().getUsersRepository().save(user);
    }

    @Override
    public void updateUser(Users user) {
        getDaoFactory().getUsersRepository().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        getDaoFactory().getUsersRepository().deleteById(id);
    }
}
