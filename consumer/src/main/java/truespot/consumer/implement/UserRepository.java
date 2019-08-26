package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truespot.model.Role;
import truespot.model.Share;
import truespot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPseudo(String pseudo);
}
