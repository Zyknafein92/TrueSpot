package truespot.consumer.contract;

import org.springframework.stereotype.Component;
import truespot.consumer.implement.UsersRepository;


public interface DaoFactory {

    UsersRepository getUsersRepository();

    void setUsersRepository(UsersRepository usersRepository);


}
