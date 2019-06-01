package truespot.business.impl;



import org.springframework.stereotype.Service;
import truespot.business.contract.UserManager;
import truespot.model.User;
import java.util.List;
import java.util.Optional;

//todo refactor selon area
@Service
public class UserManagerImpl extends BusinessManagerImpl implements UserManager {

//    @Autowired
//    BCryptPasswordEncoder encoder;


    @Override
    public List<User> findAllUser() {
        return getDaoFactory().getUserRepository().findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
       return getDaoFactory().getUserRepository().findById(id);
    }

    @Override
    public User saveUser(User user) {
        return getDaoFactory().getUserRepository().save(user);
    }

//    @Override
//    public User findByPseudo(String pseudo) {
//        return getDaoFactory().getUserRepository().findByPseudo(pseudo);
//    }

//    public long createUser(User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        User savedUser = userRepository.save(user);
//        return savedUser.getId();
//    }
//
//    public String login(User user) {
//        User foundUser = getDaoFactory().getUserRepository().findByPseudo(user.getPseudo());
//        return encoder.matches(user.getPassword(), foundUser.getPassword()) ?
//                "SUCCESS" : "FAILED";
//    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        getDaoFactory().getUserRepository().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        getDaoFactory().getUserRepository().deleteById(id);
    }
}
