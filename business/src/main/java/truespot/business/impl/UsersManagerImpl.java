package truespot.business.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import truespot.business.contract.UsersManager;
import truespot.model.Users;
import java.util.List;
import java.util.Optional;


@Service
public class UsersManagerImpl extends BusinessManagerImpl implements UsersManager {

    @Override
    public List<Users> findAllUser() {
        return getDaoFactory().getUsersRepository().findAll();
    }

    @Override
    public Optional<Users> getUser(@PathVariable Long id) {
       return getDaoFactory().getUsersRepository().findById(id);
    }

    @Override
    public Users saveUser(Users user) {
        return getDaoFactory().getUsersRepository().save(user);
    }

    @Override
    public void updateUser(Long id, Users user) {
        getDaoFactory().getUsersRepository().save(user); //todo : a corriger
    }

    @Override
    public void deleteUser(Long id) {
        getDaoFactory().getUsersRepository().deleteById(id);
    }
}
