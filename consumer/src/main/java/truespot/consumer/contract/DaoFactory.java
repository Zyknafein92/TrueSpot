package truespot.consumer.contract;


import org.springframework.beans.factory.annotation.Autowired;
import truespot.consumer.implement.*;




public interface DaoFactory {

    UsersRepository getUsersRepository();
    AreaRepository getAreaRepository();
    ClimbingRoadRepository getClimbingRoadRepository();
    ClimbingRoadTypeRepository getClimbingRoadTypeRepository();
    DifficultyRepository getDifficultyRepository();

    @Autowired
    void setUsersRepository(UsersRepository usersRepository);
    @Autowired
    void setAreaRepository(AreaRepository areaRepository);
    @Autowired
    void setClimbingRoadRepository(ClimbingRoadRepository climbingRoadRepository);
    @Autowired
    void setClimbingRoadTypeRepository(ClimbingRoadTypeRepository climbingRoadTypeRepository);
    @Autowired
    void setDifficultyRepository(DifficultyRepository difficultyRepository);
}
