package truespot.business.dto.mapper;

import org.springframework.stereotype.Component;
import truespot.business.dto.ClimbingRoadDTO;
import truespot.model.ClimbingRoad;


@Component
public class ClimbingRoadMapper {


    public static ClimbingRoadDTO objectToDTO (ClimbingRoad climbingRoad){

        ClimbingRoadDTO climbingRoadDTO = new ClimbingRoadDTO();

        climbingRoadDTO.setId(climbingRoad.getId());
        climbingRoadDTO.setName(climbingRoad.getName());
        climbingRoadDTO.setDescription(climbingRoad.getDescription());
        climbingRoadDTO.setType(climbingRoad.getType());
        climbingRoadDTO.setNumber(climbingRoad.getNumber());
        climbingRoadDTO.setLetter(climbingRoad.getLetter());
        climbingRoadDTO.setSymbol(climbingRoad.getSymbol());

        return climbingRoadDTO;
    }

    public static ClimbingRoad DTOToObject (ClimbingRoadDTO climbingRoadDTO){

        ClimbingRoad climbingRoad = new ClimbingRoad();

        climbingRoad.setName(climbingRoadDTO.getName());
        climbingRoad.setDescription(climbingRoadDTO.getDescription());
        climbingRoad.setType(climbingRoadDTO.getType());
        climbingRoad.setNumber(climbingRoadDTO.getNumber());
        climbingRoad.setLetter(climbingRoadDTO.getLetter());
        climbingRoad.setSymbol(climbingRoadDTO.getSymbol());

        return climbingRoad;
    }

    public static ClimbingRoadDTO updateDTO(ClimbingRoadDTO climbingRoadDTO, ClimbingRoad climbingRoad) {

        climbingRoadDTO.setName(climbingRoad.getName() != null ? climbingRoad.getName() : climbingRoadDTO.getName() );
        climbingRoadDTO.setDescription(climbingRoad.getDescription() != null ? climbingRoad.getDescription() : climbingRoadDTO.getDescription());
        climbingRoadDTO.setType(climbingRoad.getType() != null ? climbingRoad.getType() : climbingRoadDTO.getType() );
        climbingRoadDTO.setNumber(climbingRoad.getNumber() != 0 ? climbingRoad.getNumber() : climbingRoadDTO.getNumber() );
        climbingRoadDTO.setLetter(climbingRoad.getLetter() != ' ' ? climbingRoad.getLetter() : climbingRoadDTO.getLetter() );
        climbingRoadDTO.setSymbol(climbingRoad.getSymbol() != ' ' ? climbingRoad.getSymbol() : climbingRoadDTO.getSymbol() );

        return climbingRoadDTO;
    }
}
