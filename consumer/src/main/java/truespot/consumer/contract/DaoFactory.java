package truespot.consumer.contract;


import org.springframework.beans.factory.annotation.Autowired;
import truespot.consumer.implement.*;




public interface DaoFactory {

    AdminRepository getAdminRepository();
    AreaRepository getAreaRepository();
    ClimbingRoadRepository getClimbingRoadRepository();
    ClimbingRoadTypeRepository getClimbingRoadTypeRepository();
    DepartmentRepository getDepartmentRepository();
    DifficultyRepository getDifficultyRepository();
    SpotRepository getSpotRepository();
    TopoRepository getTopoRepository();
    UsersRepository getUsersRepository();

    @Autowired
    void setAdminRepository(AdminRepository adminRepository);
    @Autowired
    void setAreaRepository(AreaRepository areaRepository);
    @Autowired
    void setClimbingRoadRepository(ClimbingRoadRepository climbingRoadRepository);
    @Autowired
    void setClimbingRoadTypeRepository(ClimbingRoadTypeRepository climbingRoadTypeRepository);
    @Autowired
    void setDepartmentRepository(DepartmentRepository departmentRepository);
    @Autowired
    void setDifficultyRepository(DifficultyRepository difficultyRepository);
    @Autowired
    void setSpotRepository(SpotRepository spotRepository);
    @Autowired
    void setTopoRepository(TopoRepository topoRepository);
    @Autowired
    void setUsersRepository(UsersRepository usersRepository);
}
