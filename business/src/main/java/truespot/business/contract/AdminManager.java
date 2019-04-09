package truespot.business.contract;

import org.springframework.web.bind.annotation.PathVariable;
import truespot.model.Admin;

import java.util.Optional;

public interface AdminManager {

    Optional<Admin> getAdmin(@PathVariable Long id);

    Admin saveAdmin(Admin admin);

    void updateAdmin(Long id, Admin admin);
        //TODO

    void deleteAdmin(Long id);

}
