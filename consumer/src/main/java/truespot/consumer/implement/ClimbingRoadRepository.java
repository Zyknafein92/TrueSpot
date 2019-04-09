package truespot.consumer.implement;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.ClimbingRoad;

@Repository
public interface ClimbingRoadRepository extends JpaRepository <ClimbingRoad, Long> {
}
