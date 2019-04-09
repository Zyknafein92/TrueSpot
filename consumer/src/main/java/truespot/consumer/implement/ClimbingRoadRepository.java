package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimbingRoadRepository extends JpaRepository<ClimbingRoadRepository, Long> {
}
