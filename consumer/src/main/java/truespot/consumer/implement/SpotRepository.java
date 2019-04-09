package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Spot;

@Repository
public interface SpotRepository extends JpaRepository <Spot, Long> {

}
