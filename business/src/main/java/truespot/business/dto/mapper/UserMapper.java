package truespot.business.dto.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.UserManager;
import truespot.model.User;
import truespot.business.dto.UserDTO;

import java.util.Optional;

@Component
public class UserMapper {

    @Autowired
    private UserManager userManager;

     public UserDTO objectToDTO (User user) {

         UserDTO userDTO = new UserDTO();

         userDTO.setFirstName(user.getFirstName() != null ? user.getFirstName() : "");
         userDTO.setLastName(user.getLastName() != null ? user.getLastName() : "");
         userDTO.setAge(user.getAge());
         userDTO.setGender(user.getGender()!= null ? user.getGender() : "");
         userDTO.setPseudo(user.getPseudo() != null ? user.getPseudo() : "");
         userDTO.setPassword(user.getPassword() != null ? user.getPassword() : "");
         userDTO.setEmail(user.getEmail()!= null ? user.getEmail() : "");
         userDTO.setPhoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber() : "");

         return userDTO;
     }

     public User dtoToObject (UserDTO userDTO){

         User user = new User();

         user.setFirstName(userDTO.getFirstName());
         user.setLastName(userDTO.getLastName());
         user.setAge(userDTO.getAge());
         user.setGender(userDTO.getGender());
         user.setPseudo(userDTO.getPseudo());
         user.setPassword(userDTO.getPassword());
         user.setEmail(userDTO.getEmail());
         user.setPhoneNumber(userDTO.getPhoneNumber());
        // user.setAdmin(userDTO.setIsAdmin(false));
         user = userManager.saveUser(user);
         userDTO.setId(user.getId());

         return user;
     }

     public User updateRecord(Long id, User uUpdate){


         //todo.. setter ect...

        return null;
     }

}
