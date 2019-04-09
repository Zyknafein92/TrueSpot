package truespot.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.AdminManager;
import truespot.model.Admin;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    private AdminManager adminManager;


    @GetMapping(value="/admin/{id}")
    public Optional<Admin> getAdmin(@PathVariable Long id) { return adminManager.getAdmin(id); }

    @PostMapping(value="/admin")
    public Admin createAdmin(@RequestBody Admin Admin){
        return adminManager.saveAdmin(Admin);
    }

    //todo a rework
 //   @PutMapping(value = "/admin/{id}")
 //   public void updateAdmin(@PathVariable Long id , @RequestBody Admin Admin) {

    @DeleteMapping(value= "/admin/{id}")
    public void deleteAdmin(@PathVariable Long id){
        adminManager.deleteAdmin(id);
    }
}
