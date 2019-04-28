package truespot.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserManager;
import truespot.business.dto.mapper.UserMapper;
import truespot.model.User;
import truespot.business.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UserManager userManager;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="/user")
    public List<User> getUsers(){
        return userManager.findAllUser();
    }

    @GetMapping(value="/user/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        Optional<User> user = userManager.getUser(id);
        if(user.isPresent()){
            User userReal = user.get();
            return userMapper.objectToDTO(userReal);
        }throw new RuntimeException("user not found");
    }

    @PostMapping(value="/user")
    public User createUser(@RequestBody UserDTO userDTO){
        return userMapper.dtoToObject(userDTO);
    }

    @PutMapping(value = "/user/{id}")
    public void updateUser(@PathVariable Long id , @RequestBody User user) {
        userManager.updateUser(id,user);
    }

    @DeleteMapping(value= "/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userManager.deleteUser(id);
    }


}
