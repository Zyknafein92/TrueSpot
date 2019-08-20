package truespot.business.contract;

import truespot.business.dto.ClimbingRoadDTO;
import truespot.model.ClimbingRoad;

import java.util.List;

public interface ClimbingRoadManager {

    List<ClimbingRoad> findAllClimbingRoad();

    ClimbingRoad getClimbingRoad(Long id);

    ClimbingRoad saveClimbingRoad(ClimbingRoadDTO climbingRoadDTO);

    void updateClimbingRoad(ClimbingRoadDTO climbingRoadDTO);

    void deleteClimbingRoad(Long id);
}
