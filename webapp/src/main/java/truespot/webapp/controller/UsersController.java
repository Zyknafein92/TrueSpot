package truespot.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UsersManager;
import truespot.model.User;
import truespot.webapp.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UsersManager usersManager;

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return usersManager.findAllUser();
    }

    @GetMapping(value="/users/{id}")
    public UserDTO getUser(@PathVariable Long id) {
       Optional<User> user = usersManager.getUser(id);
       if(user.isPresent()){
           User userReal = user.get();
           UserDTO userDTO = new UserDTO();
           userDTO.setId(userReal.getId());
           userDTO.setName(userReal.getName());
           userDTO.setAge(userReal.getAge());
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

        user = usersManager.saveUser(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    @PutMapping(value = "/users/{id}")
    public void updateUser(@PathVariable Long id , @RequestBody User user) {
        usersManager.updateUser(id,user);
    }

    @DeleteMapping(value= "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        usersManager.deleteUser(id);
    }


}
