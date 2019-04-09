package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
