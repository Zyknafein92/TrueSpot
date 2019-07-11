package truespot.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserManager;
import truespot.model.User;
import truespot.business.dto.UserDTO;

import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserManager userManager;


    @GetMapping(value="/user")
    public List<User> getUsers(){
        return userManager.findAllUser();
    }

    @GetMapping(value="/user/{id}")
    public UserDTO getUser(@PathVariable Long id) { return userManager.getUser(id); }

    @PostMapping(value="/register")
    public User createUser(@RequestBody UserDTO userDTO){
        return userManager.saveUser(userDTO);
    }

    @PutMapping(value = "/user/{id}")
    public void updateUser(@PathVariable Long id , @RequestBody User user) {
        userManager.updateUser(id,user);
    }

    @DeleteMapping(value= "/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userManager.deleteUser(id);
    }

    @PostMapping(value="/login")
    public String login(@PathVariable User user) {
        return userManager.login(user);
    }

}
