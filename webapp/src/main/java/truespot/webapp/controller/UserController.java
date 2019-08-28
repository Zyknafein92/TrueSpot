package truespot.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserManager;
import truespot.business.dto.UserDTO;
import truespot.model.User;
import truespot.webapp.security.jwt.JwtProvider;
import truespot.webapp.security.jwt.JwtResponse;

import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userManager.findAllUser();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam(name = "id", defaultValue = "")  String id) {
        return userManager.getUser(Long.valueOf(id)); }

    @GetMapping(value="/user/myprofil")
    public User getProfil(@RequestParam(name = "pseudo", defaultValue = "") String pseudo){
        User user = userManager.findByPseudo(pseudo);
        return user;
    }

    @PostMapping(value="/register")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO){
        return userManager.saveUser(userDTO);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDTO userDTO) {
        userManager.updateUser(userDTO);
    }

    @RequestMapping(value = "/user/update/role", method = RequestMethod.PUT)
    public void updateUserRole(@RequestBody UserDTO userDTO) {
        userManager.updateUserRole(userDTO);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(name = "idUser", defaultValue = "")  String idUser){
        userManager.deleteUser(Long.valueOf(idUser));
    }



    @PostMapping(value="/login")
    public JwtResponse login (@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getPseudo(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities());
    }
}

