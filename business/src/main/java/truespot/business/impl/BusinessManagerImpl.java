package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.*;


@Service
public class BusinessManagerImpl extends BusinessManager {


    private AreaManager areaManager;
    private ClimbingRoadManager climbingRoadManager;
    private DepartmentManager departmentManager;
    private TopoManager topoManager;
    private UserManager userManager;


    //Getter

    public AreaManager getAreaManager() { return areaManager; }

    public ClimbingRoadManager getClimbingRoadManager() { return climbingRoadManager;}

    public DepartmentManager getDepartmentManager() { return departmentManager; }

    public TopoManager getTopoManager() { return topoManager; }

    public UserManager getUserManager() { return userManager; }


    //Setter

    @Autowired
    public void setAreaManager(AreaManager areaManager) { this.areaManager = areaManager; }

    @Autowired
    public void setClimbingRoadManager(ClimbingRoadManager climbingRoadManager) {
        this.climbingRoadManager = climbingRoadManager; }

    @Autowired
    public void setDepartmentManager(DepartmentManager departmentManager) { this.departmentManager = departmentManager; }

    @Autowired
    public void setTopoManager(TopoManager topoManager) { this.topoManager = topoManager; }

    @Autowired
    public void setUserManager(UserManager userManager) { this.userManager = userManager; }
}
