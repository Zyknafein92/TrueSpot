package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Area;

@Repository
public interface AreaRepository extends JpaRepository <Area, Long> {
}
