package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.*;
import truespot.model.Department;


@Service
public class BusinessManagerImpl extends BusinessManager {

    private AdminManager adminManager;
    private AreaManager areaManager;
    private ClimbingRoadManager climbingRoadManager;
    private ClimbingRoadTypeManager climbingRoadTypeManager;
    private DepartmentManager departmentManager;
    private DifficultyManager difficultyManager;
    private SpotManager spotManager;
    private TopoManager topoManager;
    private UsersManager usersManager;


    //Getter

    public AdminManager getAdminManager() { return adminManager; }

    public AreaManager getAreaManager() { return areaManager; }

    public ClimbingRoadManager getClimbingRoadManager() { return climbingRoadManager;}

    public ClimbingRoadTypeManager getClimbingRoadTypeManager() { return climbingRoadTypeManager; }

    public DepartmentManager getDepartmentManager() { return departmentManager; }

    public DifficultyManager getDifficultyManager() { return difficultyManager; }

    public SpotManager getSpotManager() { return spotManager; }

    public TopoManager getTopoManager() { return topoManager; }

    public UsersManager getUsersManager() { return usersManager; }



    //Setter
    @Autowired
    public void setAdminManager(AdminManager adminManager) { this.adminManager = adminManager; }

    @Autowired
    public void setAreaManager(AreaManager areaManager) { this.areaManager = areaManager; }

    @Autowired
    public void setClimbingRoadManager(ClimbingRoadManager climbingRoadManager) {
        this.climbingRoadManager = climbingRoadManager; }

    @Autowired
    public void setClimbingRoadTypeManager(ClimbingRoadTypeManager climbingRoadTypeManager) {
        this.climbingRoadTypeManager = climbingRoadTypeManager; }

    @Autowired
    public void setDepartmentManager(DepartmentManager departmentManager) { this.departmentManager = departmentManager; }

    @Autowired
    public void setDifficultyManager(DifficultyManager difficultyManager) { this.difficultyManager = difficultyManager; }

    @Autowired
    public void setSpotManager(SpotManager spotManager) { this.spotManager = spotManager; }

    @Autowired
    public void setTopoManager(TopoManager topoManager) { this.topoManager = topoManager; }

    @Autowired
    public void setUsersManager(UsersManager usersManager) { this.usersManager = usersManager; }
}
