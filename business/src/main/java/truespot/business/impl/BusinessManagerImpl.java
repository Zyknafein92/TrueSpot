package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.BusinessManager;
import truespot.business.contract.UsersManager;

@Service
public class BusinessManagerImpl extends BusinessManager {

    private UsersManager userManager;




    public UsersManager getUserManager(UsersManager usersManager) {
        return usersManager;
    }


    @Autowired
    public void setUserManager(UsersManager userManager) {
        this.userManager = userManager;
    }
}
