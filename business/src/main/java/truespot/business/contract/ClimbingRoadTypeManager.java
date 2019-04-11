package truespot.business.contract;

import truespot.model.ClimbingRoadType;

import java.util.List;
import java.util.Optional;

public interface ClimbingRoadTypeManager {

    Optional<ClimbingRoadType> getClimbingRoadType(Long id);

    ClimbingRoadType saveClimbingRoadType(ClimbingRoadType climbingRoadType);

    void updateClimbingRoadType(Long id, ClimbingRoadType climbingRoadType);

    void deleteClimbingRoadType(Long id);

}
