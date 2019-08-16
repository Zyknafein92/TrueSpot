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
import truespot.model.User;
import truespot.business.dto.UserDTO;
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

    @GetMapping(value="/user/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userManager.getUser(id); }

    @GetMapping(value="/user/myprofil")
    public User getProfil(@RequestParam(name = "pseudo", defaultValue = "") String pseudo){
        User user = userManager.findByPseudo(pseudo);
        return user;
    }

    @PostMapping(value="/register")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO){
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
    public JwtResponse login (@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getPseudo(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities());
    }
}

