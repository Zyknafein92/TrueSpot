package truespot.consumer.contract;


import org.springframework.beans.factory.annotation.Autowired;
import truespot.consumer.implement.*;




public interface DaoFactory {


    AreaRepository getAreaRepository();
    ClimbingRoadRepository getClimbingRoadRepository();
    DepartmentRepository getDepartmentRepository();
    RoleRepository getRoleRepository();
//    SpotRepository getSpotRepository();
    TopoRepository getTopoRepository();
    UserRepository getUserRepository();



    @Autowired
    void setAreaRepository(AreaRepository areaRepository);
    @Autowired
    void setClimbingRoadRepository(ClimbingRoadRepository climbingRoadRepository);
    @Autowired
    void setDepartmentRepository(DepartmentRepository departmentRepository);
    @Autowired
    void setRoleRepository(RoleRepository roleRepository);
//    @Autowired
//    void setSpotRepository(SpotRepository spotRepository);
    @Autowired
    void setTopoRepository(TopoRepository topoRepository);
    @Autowired
    void setUserRepository(UserRepository userRepository);
}
