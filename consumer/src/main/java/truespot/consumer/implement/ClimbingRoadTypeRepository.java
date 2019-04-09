package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.ClimbingRoadType;

@Repository
public interface ClimbingRoadTypeRepository extends JpaRepository <ClimbingRoadType,Long> {
}
