package truespot.consumer.contract;


import org.springframework.beans.factory.annotation.Autowired;
import truespot.consumer.implement.AreaRepository;
import truespot.consumer.implement.UsersRepository;


public interface DaoFactory {

    UsersRepository getUsersRepository();
    AreaRepository getAreaRepository();

    @Autowired
    void setUsersRepository(UsersRepository usersRepository);

    @Autowired
    void setAreaRepository(AreaRepository areaRepository);

}
