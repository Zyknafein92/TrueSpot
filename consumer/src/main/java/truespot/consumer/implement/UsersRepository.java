package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import truespot.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
