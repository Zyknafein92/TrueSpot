package truespot.webapp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UsersManager;
import truespot.model.Users;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UsersManager usersManager;

    @GetMapping(value="/users")
    public List<Users> getUsers(){
        return usersManager.findAllUser();
    }

    @GetMapping(value="/users/{id}")
    public Optional<Users> getUser(@PathVariable Long id) {
        return usersManager.getUser(id);
    }

    @PostMapping(value="/users")
    public Users createUser(@RequestBody Users user){
        return usersManager.saveUser(user);
    }

    @PutMapping(value = "/users/{id}")
    public void updateUser(@PathVariable Long id , @RequestBody Users user) {
        usersManager.updateUser(id,user);
    }

    @DeleteMapping(value= "/users/{id}")
    public void deleteUser(@PathVariable Long id){
        usersManager.deleteUser(id);
    }


}
