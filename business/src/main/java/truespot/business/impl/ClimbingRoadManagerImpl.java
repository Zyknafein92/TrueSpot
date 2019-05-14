package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.ClimbingRoadManager;
import truespot.model.ClimbingRoad;

import java.util.List;
import java.util.Optional;
//todo : refactor selon Area
@Service
public class ClimbingRoadManagerImpl extends BusinessManagerImpl implements ClimbingRoadManager {

    @Override
    public List<ClimbingRoad> findAllClimbingRoad() {
        return getDaoFactory().getClimbingRoadRepository().findAll();
    }

    @Override
    public Optional<ClimbingRoad> getClimbingRoad(Long id) {
        return getDaoFactory().getClimbingRoadRepository().findById(id);
    }

    @Override
    public ClimbingRoad saveClimbingRoad(ClimbingRoad climbingRoad) {
        return getDaoFactory().getClimbingRoadRepository().save(climbingRoad);
    }

    @Override
    public void updateClimbingRoad(Long id, ClimbingRoad climbingRoad) {
      climbingRoad.setId(id);
      getDaoFactory().getClimbingRoadRepository().save(climbingRoad);
    }

    @Override
    public void deleteClimbingRoad(Long id) {
        getDaoFactory().getClimbingRoadRepository().deleteById(id);
    }
}
