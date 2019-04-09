package truespot.business.contract;

import truespot.model.ClimbingRoad;

import java.util.List;
import java.util.Optional;

public interface ClimbingRoadManager {

    List<ClimbingRoad> findAllClimbingRoad();

    Optional<ClimbingRoad> getClimbingRoad(Long id);

    ClimbingRoad saveClimbingRoad(ClimbingRoad climbingRoad);

    void updateClimbingRoad(Long id, ClimbingRoad climbingRoad);

    void deleteClimbingRoad(Long id);
}
