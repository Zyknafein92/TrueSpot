package truespot.consumer.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.consumer.contract.DaoFactory;

@Component
public class DaoFactoryImpl implements DaoFactory {

    private UsersRepository usersRepository;


    @Override
    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    @Override
    @Autowired
   public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
