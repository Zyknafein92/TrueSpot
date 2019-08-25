package truespot.business.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import truespot.business.contract.RoleManager;
import truespot.business.contract.UserManager;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.UserMapper;
import truespot.consumer.implement.RoleRepository;
import truespot.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;


@Service
public class UserManagerImpl extends BusinessManagerImpl implements UserManager {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleManager roleManager;

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
                    userOptional.get().getBirthDate(),
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
        Set<Role> roles= new HashSet<>();

        Role roleUser = roleManager.findByRoleName(RoleName.ROLE_USER);

        if (userFind == null){
            User user = UserMapper.dtoToObject(userDTO);


            if(user.getRoles().isEmpty()){
                roles.add(roleUser);
            }

            user.setRoles(roles);
            user.setPassword(encoder.encode(user.getPassword()));
            User userToSave = getDaoFactory().getUserRepository().save(user);
            return new ResponseEntity<>(userToSave, HttpStatus.OK);
        }else {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Ce PSEUDO EXISTE DEJA");
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public User findByPseudo (String pseudo) {
        return getDaoFactory().getUserRepository().findByPseudo(pseudo);
    }


    @Override
    public void updateUser(UserDTO userDTO) {
        User user = getDaoFactory().getUserRepository().findByPseudo(userDTO.getPseudo());
        String password = user.getPassword();
        encoder.encode(userDTO.getPassword());

        if (!encoder.matches(password, userDTO.getPassword())) {
            user.setPassword(encoder.encode(userDTO.getPassword()));
        }
        user =  UserMapper.dtoToObject(userDTO);
        getDaoFactory().getUserRepository().save(user);
    }

    @Override
    public void updateUserRole(UserDTO userDTO){
        User user = getDaoFactory().getUserRepository().findByPseudo(userDTO.getPseudo());

        Role adminRole = roleManager.findByRoleName(RoleName.ROLE_ADMIN);
        Role userRole = roleManager.findByRoleName(RoleName.ROLE_USER);

        Set<Role> roleToAdd = new HashSet<>();


        user.getRoles().removeAll(user.getRoles());
        roleToAdd.add(adminRole);
        user.setRoles(roleToAdd);

        getDaoFactory().getUserRepository().save(user);
    }

    @Override
    public void deleteUser(Long id) {

        User user = getDaoFactory().getUserRepository().getOne(id);
        List<Topo> topos = getDaoFactory().getTopoRepository().findAllByUser_Pseudo(user.getPseudo());
        if(topos.size() > 0){
            for (Topo topo: topos) {
                getDaoFactory().getTopoRepository().delete(topo);
            }
        }
        user.getRoles().removeAll(user.getRoles());
        //clean le role

        getDaoFactory().getUserRepository().delete(getDaoFactory().getUserRepository().getOne(id));
    }

}
