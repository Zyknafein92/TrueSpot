package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.BusinessManager;
import truespot.business.contract.RoleManager;
import truespot.model.Role;
import truespot.model.RoleName;

@Service
public class RoleManagerImpl extends BusinessManagerImpl implements RoleManager {

    @Override
    public Role setRole(String role) {
        return role.equals("admin") ? getDaoFactory().getRoleRepository().findByName(RoleName.ROLE_ADMIN) : getDaoFactory().getRoleRepository().findByName(RoleName.ROLE_USER) ;
    }

}
