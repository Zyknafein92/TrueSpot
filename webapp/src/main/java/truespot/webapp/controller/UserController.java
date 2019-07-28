package truespot.webapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.UserManager;
import truespot.model.ApiError;
import truespot.model.AuthLoginInfo;
import truespot.model.JwtResponse;
import truespot.model.User;
import truespot.business.dto.UserDTO;
import truespot.webapp.configuration.JwtAuthenticationFilter;
import truespot.webapp.configuration.JwtTokenUtil;
import truespot.webapp.configuration.model.AuthToken;

import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private JwtAuthenticationFilter jWTAuthenticationFilter;


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

   //@PostMapping(value="/login")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
   public JwtResponse login(@RequestBody User user) {
        System.out.println("USER TOKEN "+  user.getPseudo());


      final String token = jwtTokenUtil.generateToken(user);
      System.out.println("TOKEN:" + token);
      JwtResponse jwtResponse = new JwtResponse();
      jwtResponse.setAccessToken(token);
      jwtResponse.setPseudo(user.getPseudo());
      jwtResponse.setType("ADMIN");
      jwtResponse.setAuthorities(new String[1]);

     /* if (token == null) {
          ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, " EROOOOOOOOOOOOOOO");
          return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
          //return new ResponseEntity(HttpStatus.NOT_FOUND);
      } else {
          System.out.println("TOKEN:" + token);
          JwtResponse jwtResponse = new JwtResponse();
          jwtResponse.setAccessToken(token);
          jwtResponse.setPseudo(user.getPseudo());
          jwtResponse.setType("ADMIN");
          jwtResponse.setAuthorities(new String[1]);
          return ResponseEntity.ok(new AuthToken(token, user.getPseudo());
      }*/


        return jwtResponse;
       // return userManager.login(user);
       //this.jWTAuthenticationFilter = new JwtAuthenticationFilter();
      // return this.jWTAuthenticationFilter .doGenerateToken();
    }

}
