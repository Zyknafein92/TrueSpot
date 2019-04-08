package truespot.consumer.contract;


import org.springframework.beans.factory.annotation.Autowired;
import truespot.consumer.implement.UsersRepository;


public interface DaoFactory {

    UsersRepository getUsersRepository();

    @Autowired
    void setUsersRepository(UsersRepository usersRepository);


}
