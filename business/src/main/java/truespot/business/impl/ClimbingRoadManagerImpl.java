package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.ClimbingRoadManager;
import truespot.business.dto.ClimbingRoadDTO;
import truespot.business.dto.mapper.ClimbingRoadMapper;
import truespot.model.Area;
import truespot.model.ClimbingRoad;

import java.util.List;

@Service
public class ClimbingRoadManagerImpl extends BusinessManagerImpl implements ClimbingRoadManager {

    @Override
    public List<ClimbingRoad> findAllClimbingRoad() {
        return getDaoFactory().getClimbingRoadRepository().findAll();
    }

    @Override
    public List<ClimbingRoad>  findAllClimbingRoadByIdArea(Long idArea) {
        return getDaoFactory().getClimbingRoadRepository().findAllByArea(idArea);
    }

    @Override
    public ClimbingRoad getClimbingRoad(Long id) {
       // ClimbingRoad climbingRoad = getDaoFactory().getClimbingRoadRepository().getOne(id);
        return getDaoFactory().getClimbingRoadRepository().getOne(id);
    }

    @Override
    public ClimbingRoad saveClimbingRoad (ClimbingRoadDTO climbingRoadDTO) {

        Area area = getDaoFactory().getAreaRepository().getOne(new Long(climbingRoadDTO.getIdArea()));
        ClimbingRoad climbingRoad = ClimbingRoadMapper.DTOToObject(climbingRoadDTO);
        climbingRoad.setArea(area);

        return getDaoFactory().getClimbingRoadRepository().save(climbingRoad);
    }

    @Override
    public void updateClimbingRoad( ClimbingRoadDTO climbingRoadDTO) {
        Area area = getDaoFactory().getAreaRepository().getOne(new Long(climbingRoadDTO.getIdArea()));
        ClimbingRoad climbingRoad = ClimbingRoadMapper.DTOToObject(climbingRoadDTO);
        climbingRoad.setArea(area);
        climbingRoad.setId(climbingRoadDTO.getId());
        getDaoFactory().getClimbingRoadRepository().save(climbingRoad);
    }

    @Override
    public void deleteClimbingRoad(Long idRoad) {
        getDaoFactory().getClimbingRoadRepository().delete(getDaoFactory().getClimbingRoadRepository().getOne(idRoad));
    }
}
