package truespot.consumer.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.consumer.contract.DaoFactory;

@Component
public class DaoFactoryImpl implements DaoFactory {

    private UsersRepository usersRepository;
    private AreaRepository areaRepository;


    // Getters
    @Override
    public UsersRepository getUsersRepository() {
        return usersRepository;
    }
    @Override
    public AreaRepository getAreaRepository() {
        return areaRepository;
    }


    //Setters
    @Override
    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Autowired
    public void setAreaRepository(AreaRepository areaRepository) { this.areaRepository = areaRepository; }


}
