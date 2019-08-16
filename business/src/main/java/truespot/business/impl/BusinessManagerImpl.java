package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.*;


@Service
public class BusinessManagerImpl extends BusinessManager {


    private AreaManager areaManager;
    private ClimbingRoadManager climbingRoadManager;
    private DepartmentManager departmentManager;
    private ShareManager shareManager;
    private TopoManager topoManager;
    private UserMessageManager userMessageManager;
    private UserManager userManager;



    //Getter

    public AreaManager getAreaManager() { return areaManager; }

    public ClimbingRoadManager getClimbingRoadManager() { return climbingRoadManager;}

    public DepartmentManager getDepartmentManager() { return departmentManager; }

    public ShareManager getShareManager() { return shareManager;}

    public TopoManager getTopoManager() { return topoManager; }

    public UserMessageManager getUserMessageManager() { return userMessageManager; }

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
    public void setShareManager (ShareManager shareManager) { this.shareManager = shareManager; }

    @Autowired
    public void setTopoManager(TopoManager topoManager) { this.topoManager = topoManager; }

    @Autowired
    public void setUserMessageManager(UserMessageManager userMessageManager) {
        this.userMessageManager = userMessageManager;
    }

    @Autowired
    public void setUserManager(UserManager userManager) { this.userManager = userManager; }
}
