package truespot.business.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import truespot.business.ResponseMessage;
import truespot.business.contract.UserManager;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.UserMapper;
import truespot.consumer.implement.RoleRepository;
import truespot.model.User;
import java.util.List;
import java.util.Optional;



@Service
public class UserManagerImpl extends BusinessManagerImpl implements UserManager {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<User> findAllUser() {
        return getDaoFactory().getUserRepository().findAll();
    }

    @Override
    public UserDTO getUser(Long id) {

        Optional<User> userOptional = getDaoFactory().getUserRepository().findById(id);
        User user = null;

        if(userOptional.isPresent()){
            user = new User (
                    userOptional.get().getFirstName(),
                    userOptional.get().getLastName(),
                    userOptional.get().getAge(),
                    userOptional.get().getGender(),
                    userOptional.get().getPseudo(),
                    userOptional.get().getPassword(),
                    userOptional.get().getEmail(),
                    userOptional.get().getPhoneNumber());
                    userOptional.get().getRoles();
        }
        return user != null ? UserMapper.objectToDTO(user) : null;

    }

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = UserMapper.dtoToObject(userDTO);
        user.setPassword(encoder.encode(user.getPassword()));
      return getDaoFactory().getUserRepository().save(user);
    }


    @Override
    public User findByPseudo (String pseudo) {
        return getDaoFactory().getUserRepository().findByPseudo(pseudo);
    }


    @Override
    public String login (User user) {
        User foundUser = getDaoFactory().getUserRepository().findByPseudo(user.getPseudo());

       return encoder.matches(user.getPassword(), foundUser.getPassword()) ?
              "SUCCESS" : "FAILED";

    }

    @Override
    public void updateUser(Long id, User user) {
        UserDTO userDTO = getUser(id);
        UserMapper.updateDTO(userDTO, user);
        user.setId(id);
        getDaoFactory().getUserRepository().save(user);
    }

    @Override
    public void deleteUser(Long id) {
        getDaoFactory().getUserRepository().deleteById(id);
    }
}
