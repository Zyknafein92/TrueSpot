package truespot.business.dto.mapper;


import org.springframework.stereotype.Component;
import truespot.model.User;
import truespot.business.dto.UserDTO;

@Component
public class UserMapper {

     public static UserDTO objectToDTO (User user) {

         UserDTO userDTO = new UserDTO();

         userDTO.setId(user.getId() != null ? user.getId() : userDTO.getId());
         userDTO.setFirstName(user.getFirstName() != null ? user.getFirstName() : userDTO.getFirstName());
         userDTO.setLastName(user.getLastName() != null ? user.getLastName() : userDTO.getLastName());
         userDTO.setAge(user.getAge() != 0 ? user.getAge() : userDTO.getAge());
         userDTO.setGender(user.getGender() != null ? user.getGender() : userDTO.getGender());
         userDTO.setPseudo(user.getPseudo() != null ? user.getPseudo() : userDTO.getPseudo());
         userDTO.setPassword(user.getPassword() != null ? user.getPassword() : userDTO.getPassword());
         userDTO.setEmail(user.getEmail() != null ? user.getEmail() : userDTO.getEmail());
         userDTO.setPhoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber() : userDTO.getPhoneNumber());
         userDTO.setRoles(user.getRoles() != null ? user.getRoles() : userDTO.getRoles());

         return userDTO;
     }

     public static User dtoToObject (UserDTO userDTO){

         User user = new User();

         user.setFirstName(userDTO.getFirstName() != null ? userDTO.getFirstName() : user.getFirstName());
         user.setLastName(userDTO.getLastName() != null ? userDTO.getLastName() : user.getLastName());
         user.setAge(userDTO.getAge() != 0 ? userDTO.getAge() : user.getAge());
         user.setGender(userDTO.getGender() != null ? userDTO.getGender() : user.getGender());
         user.setPseudo(userDTO.getPseudo() != null ? userDTO.getPseudo() : user.getPseudo());
         user.setPassword(userDTO.getPassword() != null ? userDTO.getPassword() : user.getPassword());
         user.setEmail(userDTO.getEmail() != null ? userDTO.getEmail() : user.getEmail());
         user.setPhoneNumber(userDTO.getPhoneNumber() != null ? userDTO.getPhoneNumber() : user.getPhoneNumber());
         user.setRoles(userDTO.getRoles() != null ? userDTO.getRoles() : user.getRoles());
         userDTO.setId(user.getId());


         return user;
     }

     public static UserDTO updateDTO(UserDTO userDTO, User user){

         userDTO.setFirstName(user.getFirstName() != null ? user.getFirstName() : userDTO.getFirstName());
         userDTO.setLastName(user.getLastName() != null ? user.getLastName() : userDTO.getLastName());
         userDTO.setAge(user.getAge() != 0 ? user.getAge() : userDTO.getAge());
         userDTO.setGender(user.getGender() != null ? user.getGender() : userDTO.getGender());
         userDTO.setPseudo(user.getPseudo() != null ? user.getPseudo() : userDTO.getPseudo());
         userDTO.setPassword(user.getPassword() != null ? user.getPassword() : userDTO.getPassword());
         userDTO.setEmail(user.getEmail() != null ? user.getEmail() : userDTO.getEmail());
         userDTO.setPhoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber() : userDTO.getPhoneNumber());
         userDTO.setRoles(user.getRoles() != null ? user.getRoles() : userDTO.getRoles());

        return userDTO;
     }

}
