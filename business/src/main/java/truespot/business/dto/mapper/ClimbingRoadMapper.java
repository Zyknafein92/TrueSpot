package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.ClimbingRoadManager;
import truespot.business.dto.ClimbingRoadDTO;
import truespot.model.ClimbingRoad;

@Component
public class ClimbingRoadMapper {

    @Autowired
    private ClimbingRoadManager climbingRoadManager;

    public ClimbingRoadDTO objectToDTO (ClimbingRoad climbingRoad){

        ClimbingRoadDTO climbingRoadDTO = new ClimbingRoadDTO();

        climbingRoadDTO.setName(climbingRoad.getName());
        climbingRoadDTO.setDescription(climbingRoad.getDescription());
        climbingRoadDTO.setType(climbingRoad.getType());
        climbingRoadDTO.setNumber(climbingRoad.getNumber());
        climbingRoadDTO.setLetter(climbingRoad.getLetter());
        climbingRoadDTO.setSymbol(climbingRoad.getSymbol());

        return climbingRoadDTO;
    }

    public ClimbingRoad DTOToObject (ClimbingRoadDTO climbingRoadDTO){

        ClimbingRoad climbingRoad = new ClimbingRoad();
        climbingRoad.setName(climbingRoadDTO.getName());
        climbingRoad.setDescription(climbingRoadDTO.getDescription());
        climbingRoad.setType(climbingRoadDTO.getType());
        climbingRoad.setNumber(climbingRoadDTO.getNumber());
        climbingRoad.setLetter(climbingRoadDTO.getLetter());
        climbingRoad.setSymbol(climbingRoadDTO.getSymbol());
        climbingRoad = climbingRoadManager.saveClimbingRoad(climbingRoad);
        climbingRoadDTO.setId(climbingRoad.getId());
        return climbingRoad;
    }
}
