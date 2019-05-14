package truespot.business.impl;


import org.springframework.stereotype.Service;
import truespot.business.contract.UserManager;
import truespot.model.User;
import java.util.List;
import java.util.Optional;

//todo refactor selon area
@Service
public class UserManagerImpl extends BusinessManagerImpl implements UserManager {

    @Override
    public List<User> findAllUser() {
        return getDaoFactory().getUsersRepository().findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
       return getDaoFactory().getUsersRepository().findById(id);
    }

    @Override
    public User saveUser(User user) {
        return getDaoFactory().getUsersRepository().save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        getDaoFactory().getUsersRepository().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        getDaoFactory().getUsersRepository().deleteById(id);
    }
}
