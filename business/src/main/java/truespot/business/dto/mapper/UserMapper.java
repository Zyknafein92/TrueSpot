package truespot.business.dto.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.UserManager;
import truespot.model.User;
import truespot.business.dto.UserDTO;

@Component
public class UserMapper {

    @Autowired
    private UserManager userManager;

     public UserDTO objectToDTO (User user) {

         UserDTO userDTO = new UserDTO();

         userDTO.setPseudo(user.getPseudo() != null ? user.getPseudo() : "");
         //todo tous les attributs


         return userDTO;
     }

     public User dtoToObject (UserDTO userDTO){
         User user = new User();
         //todo :  même chose inverse

         return user;
     }

     public User updateRecord(Long id, User uUpdate){

         User user = new User();

        // user = userManager.getUser(id);
         //todo.. setter ect...

         return user;
     }

}
