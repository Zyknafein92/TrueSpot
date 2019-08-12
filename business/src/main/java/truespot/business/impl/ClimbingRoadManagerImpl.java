package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.ClimbingRoadManager;
import truespot.business.dto.ClimbingRoadDTO;
import truespot.business.dto.mapper.ClimbingRoadMapper;
import truespot.model.Area;
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
    public ClimbingRoadDTO getClimbingRoad(Long id) {

        Optional<ClimbingRoad> climbingRoadOptional = getDaoFactory().getClimbingRoadRepository().findById(id);

        ClimbingRoad climbingRoad = null;

        if(climbingRoadOptional.isPresent() ) {
            climbingRoad = new ClimbingRoad (
                    climbingRoadOptional.get().getName(),
                    climbingRoadOptional.get().getDescription(),
                    climbingRoadOptional.get().getType(),
                    climbingRoadOptional.get().getNumber(),
                    climbingRoadOptional.get().getLetter(),
                    climbingRoadOptional.get().getSymbol()
            );
        }
        return climbingRoad != null ? ClimbingRoadMapper.objectToDTO(climbingRoad) : null;
    }

    @Override
    public ClimbingRoad saveClimbingRoad (ClimbingRoadDTO climbingRoadDTO) {

        Area area = getDaoFactory().getAreaRepository().getOne(new Long(climbingRoadDTO.getIdArea()));
        ClimbingRoad climbingRoad = ClimbingRoadMapper.DTOToObject(climbingRoadDTO);
        climbingRoad.setArea(area);

        return getDaoFactory().getClimbingRoadRepository().save(climbingRoad);
    }

    @Override
    public void updateClimbingRoad(Long id, ClimbingRoad climbingRoad) {
        ClimbingRoadDTO climbingRoadDTO = getClimbingRoad(id);
        ClimbingRoadMapper.updateDTO(climbingRoadDTO, climbingRoad);
        climbingRoad.setId(id);
        getDaoFactory().getClimbingRoadRepository().save(climbingRoad);
    }

    @Override
    public void deleteClimbingRoad(Long id) {
        getDaoFactory().getClimbingRoadRepository().deleteById(id);
    }
}
