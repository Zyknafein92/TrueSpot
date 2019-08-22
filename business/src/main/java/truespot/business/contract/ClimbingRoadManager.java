package truespot.business.contract;

import truespot.business.dto.ClimbingRoadDTO;
import truespot.model.ClimbingRoad;

import java.util.List;

public interface ClimbingRoadManager {

    List<ClimbingRoad> findAllClimbingRoad();

    List<ClimbingRoad> findAllClimbingRoadByIdArea(Long idArea);

    ClimbingRoad getClimbingRoad(Long id);

    ClimbingRoad saveClimbingRoad(ClimbingRoadDTO climbingRoadDTO);

    void updateClimbingRoad(ClimbingRoadDTO climbingRoadDTO);

    void deleteClimbingRoad(Long idRoad);
}
