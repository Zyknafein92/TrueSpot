package truespot.business.contract;

import truespot.business.dto.ClimbingRoadDTO;
import truespot.model.ClimbingRoad;

import java.util.List;

public interface ClimbingRoadManager {

    List<ClimbingRoad> findAllClimbingRoad();

    ClimbingRoadDTO getClimbingRoad(Long id);

    ClimbingRoad saveClimbingRoad(ClimbingRoadDTO climbingRoadDTO);

    void updateClimbingRoad(Long id, ClimbingRoad climbingRoad);

    void deleteClimbingRoad(Long id);
}
