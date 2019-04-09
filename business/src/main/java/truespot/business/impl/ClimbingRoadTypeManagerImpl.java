package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.ClimbingRoadTypeManager;
import truespot.model.ClimbingRoadType;

import java.util.Optional;

@Service
public class ClimbingRoadTypeManagerImpl extends BusinessManagerImpl implements ClimbingRoadTypeManager {

    @Override
    public Optional<ClimbingRoadType> getClimbingRoad(Long id) {
        return getDaoFactory().getClimbingRoadTypeRepository().findById(id);
    }

    @Override
    public ClimbingRoadType saveClimbingRoadType(ClimbingRoadType climbingRoadType) {
        return getDaoFactory().getClimbingRoadTypeRepository().save(climbingRoadType);
    }

    @Override
    public void updateClimbingRoadType(Long id, ClimbingRoadType climbingRoadType) {
        //todo
    }

    @Override
    public void deleteClimbingRoadType(Long id) {
        getDaoFactory().getClimbingRoadTypeRepository().deleteById(id);
    }
}
