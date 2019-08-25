package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.RoleManager;
import truespot.model.Role;
import truespot.model.RoleName;

import java.util.Collection;
import java.util.stream.Stream;

@Service
public class RoleManagerImpl extends BusinessManagerImpl implements RoleManager {

    @Override
    public Role findByRoleName(RoleName roleName) {
        return getDaoFactory().getRoleRepository().findByName(roleName);
    }

}
