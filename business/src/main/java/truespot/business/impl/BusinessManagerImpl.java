package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.*;
import truespot.model.ClimbingRoad;

@Service
public class BusinessManagerImpl extends BusinessManager {

     private UsersManager usersManager;
     private AreaManager areaManager;
     private ClimbingRoadManager climbingRoadManager;
     private ClimbingRoadTypeManager climbingRoadTypeManager;
     private DifficultyManager difficultyManager;


    public UsersManager getUsersManager(UsersManager usersManager) { return usersManager; }

    public AreaManager getAreaManager() { return areaManager; }

    public ClimbingRoadManager getClimbingRoadManager() { return climbingRoadManager;
    }
    public ClimbingRoadTypeManager getClimbingRoadTypeManager() { return climbingRoadTypeManager; }

    public DifficultyManager getDifficultyManager() { return difficultyManager; }

    @Autowired
    public void setUserManager(UsersManager usersManager) { this.usersManager = usersManager; }

    @Autowired
    public void setAreaManager(AreaManager areaManager) { this.areaManager = areaManager; }

    @Autowired
    public void setClimbingRoadManager(ClimbingRoadManager climbingRoadManager) {
        this.climbingRoadManager = climbingRoadManager; }

    @Autowired
    public void setClimbingRoadTypeManager(ClimbingRoadTypeManager climbingRoadTypeManager) {
        this.climbingRoadTypeManager = climbingRoadTypeManager; }

    @Autowired
    public void setDifficultyManager(DifficultyManager difficultyManager) { this.difficultyManager = difficultyManager; }
}
