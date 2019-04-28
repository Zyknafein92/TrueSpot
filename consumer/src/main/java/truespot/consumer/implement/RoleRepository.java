package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
