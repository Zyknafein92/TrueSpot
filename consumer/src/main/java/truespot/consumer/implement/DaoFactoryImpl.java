package truespot.consumer.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.consumer.contract.DaoFactory;

@Component
public class DaoFactoryImpl implements DaoFactory {


    private AreaRepository areaRepository;
    private ClimbingRoadRepository climbingRoadRepository;
    private DepartmentRepository departmentRepository;
    private SpotRepository spotRepository;
    private TopoRepository topoRepository;
    private UsersRepository usersRepository;





    // Getters
    @Override
    public AreaRepository getAreaRepository() {
        return areaRepository;
    }
    @Override
    public ClimbingRoadRepository getClimbingRoadRepository() { return climbingRoadRepository; }
    @Override
    public DepartmentRepository getDepartmentRepository() { return departmentRepository; }
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
    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository; }

    @Override
    @Autowired
    public void setClimbingRoadRepository(ClimbingRoadRepository climbingRoadRepository) {
        this.climbingRoadRepository = climbingRoadRepository; }


    @Override
    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
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
