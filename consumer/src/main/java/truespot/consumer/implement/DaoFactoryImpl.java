package truespot.consumer.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.consumer.contract.DaoFactory;

@Component
public class DaoFactoryImpl implements DaoFactory {

    private UsersRepository usersRepository;
    private AreaRepository areaRepository;
    private ClimbingRoadRepository climbingRoadRepository;
    private ClimbingRoadTypeRepository climbingRoadTypeRepository;
    private DifficultyRepository difficultyRepository;


    // Getters
    @Override
    public UsersRepository getUsersRepository() {
        return usersRepository;
    }
    @Override
    public AreaRepository getAreaRepository() {
        return areaRepository;
    }
    @Override
    public ClimbingRoadRepository getClimbingRoadRepository() { return climbingRoadRepository; }
    @Override
    public ClimbingRoadTypeRepository getClimbingRoadTypeRepository() { return climbingRoadTypeRepository; }
    @Override
    public DifficultyRepository getDifficultyRepository() { return difficultyRepository; }


    //Setters
    @Override
    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository; }

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
    public void setDifficultyRepository(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }


}
