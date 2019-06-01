package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import truespot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByPseudo(String pseudo);
}
