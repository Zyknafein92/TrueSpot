package truespot.business.contract;

import truespot.model.Role;
import truespot.model.RoleName;


public interface RoleManager {

    Role findByRoleName(RoleName roleName);

}
