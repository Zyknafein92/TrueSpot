package truespot.consumer.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.consumer.contract.DaoFactory;

@Component
public class DaoFactoryImpl implements DaoFactory {

    private AdminRepository adminRepository;
    private AreaRepository areaRepository;
    private ClimbingRoadRepository climbingRoadRepository;
    private ClimbingRoadTypeRepository climbingRoadTypeRepository;
    private DepartmentRepository departmentRepository;
    private DifficultyRepository difficultyRepository;
    private SpotRepository spotRepository;
    private TopoRepository topoRepository;
    private UsersRepository usersRepository;





    // Getters
    @Override
    public AdminRepository getAdminRepository() { return adminRepository; }
    @Override
    public AreaRepository getAreaRepository() {
        return areaRepository;
    }
    @Override
    public ClimbingRoadRepository getClimbingRoadRepository() { return climbingRoadRepository; }
    @Override
    public ClimbingRoadTypeRepository getClimbingRoadTypeRepository() { return climbingRoadTypeRepository; }
    @Override
    public DepartmentRepository getDepartmentRepository() { return departmentRepository; }
    @Override
    public DifficultyRepository getDifficultyRepository() { return difficultyRepository; }
    @Override
    public SpotRepository getSpotRepository() { return spotRepository; }
    @Override
    public TopoRepository getTopoRepository() { return topoRepository; }
    @Override
    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    //Setters
    @Override
    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Autowired
    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository; }

    @Override
    @Autowired
    public void setClimbingRoadRepository(ClimbingRoadRepository climbingRoadRepository) {
        this.climbingRoadRepository = climbingRoadRepository; }

    @Override
    @Autowired
    public void setClimbingRoadTypeRepository(ClimbingRoadTypeRepository climbingRoadTypeRepository) {
        this.climbingRoadTypeRepository = climbingRoadTypeRepository;
    }

    @Override
    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Autowired
    public void setDifficultyRepository(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    @Autowired
    public void setSpotRepository(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    @Autowired
    public void setTopoRepository(TopoRepository topoRepository) {
        this.topoRepository = topoRepository;
    }

    @Override
    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository; }


}
