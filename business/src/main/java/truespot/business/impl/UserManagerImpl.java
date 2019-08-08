package truespot.business.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import truespot.business.contract.UserManager;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.UserMapper;
import truespot.consumer.implement.RoleRepository;
import truespot.model.ApiError;
import truespot.model.Role;
import truespot.model.RoleName;
import truespot.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


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
        }
        return user != null ? UserMapper.objectToDTO(user) : null;

    }

    @Override
    public ResponseEntity<Object> saveUser(UserDTO userDTO) {

            User userFind = getDaoFactory().getUserRepository().findByPseudo(userDTO.getPseudo());
            if (userFind == null){
                User user = UserMapper.dtoToObject(userDTO);
                Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
                Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
                Set<Role> roles = new HashSet<>();

                if(user.getRoles().isEmpty()){
                    roles.add(userRole);
                }

                user.setRoles(roles);
                user.setPassword(encoder.encode(user.getPassword()));
                User userToSave = getDaoFactory().getUserRepository().save(user);
                return new ResponseEntity<>(userToSave, HttpStatus.OK);
            }else{
                ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Ce PSEUDO EXISTE DEJA");
                return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
            }
    }


    @Override
    public User findByPseudo (String pseudo) {
        return getDaoFactory().getUserRepository().findByPseudo(pseudo);
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
