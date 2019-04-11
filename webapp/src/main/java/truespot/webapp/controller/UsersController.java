package truespot.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserManager;
import truespot.model.User;
import truespot.webapp.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UserManager userManager;

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userManager.findAllUser();
    }

    @GetMapping(value="/users/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        Optional<User> user = userManager.getUser(id);
        if(user.isPresent()){
            User userReal = user.get();
            UserDTO userDTO = new UserDTO();

            userDTO.setPseudo(userReal.getPseudo());
            userDTO.setAge(userReal.getAge());
            userDTO.setGender(userReal.getGender());
            userDTO.setEmail(userReal.getEmail());

            return userDTO;
        }throw new RuntimeException("user not found");
    }

    @PostMapping(value="/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        User user = new User();

        user.setName(userDTO.getName());
        user.setRealName(userDTO.getRealName());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        user.setPseudo(userDTO.getPseudo());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        user = userManager.saveUser(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    @PutMapping(value = "/users/{id}")
    public void updateUser(@PathVariable Long id , @RequestBody User user) {
        userManager.updateUser(id, user);
    }

    @DeleteMapping(value= "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userManager.deleteUser(id);
    }


}
