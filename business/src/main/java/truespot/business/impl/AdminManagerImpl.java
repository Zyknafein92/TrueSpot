package truespot.business.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import truespot.business.contract.AdminManager;
import truespot.model.Admin;

import java.util.Optional;

@Service
public class AdminManagerImpl extends BusinessManagerImpl implements AdminManager {

    @Override
    public Optional<Admin> getAdmin(@PathVariable Long id) {
        return getDaoFactory().getAdminRepository().findById(id);
    }


    @Override
    public Admin saveAdmin(Admin admin) {
        return getDaoFactory().getAdminRepository().save(admin);
    }

    @Override
    public void updateAdmin(Long id, Admin admin) {
        //TODO
    }

    @Override
    public void deleteAdmin(Long id) { getDaoFactory().getAdminRepository().deleteById(id);}
}

