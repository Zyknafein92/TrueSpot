package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import truespot.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

}
