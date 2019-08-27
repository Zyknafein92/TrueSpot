package truespot.business.dto.mapper;

import org.springframework.stereotype.Component;
import truespot.business.dto.ClimbingRoadDTO;
import truespot.model.ClimbingRoad;


@Component
public class ClimbingRoadMapper {


    public static ClimbingRoadDTO objectToDTO (ClimbingRoad climbingRoad){

        ClimbingRoadDTO climbingRoadDTO = new ClimbingRoadDTO();

        climbingRoadDTO.setId(climbingRoad.getId());
        climbingRoadDTO.setIdArea(climbingRoad.getArea() != null ? Long.toString(AreaMapper.objectToDTO(climbingRoad.getArea()).getId()): climbingRoadDTO.getIdArea());
        climbingRoadDTO.setName(climbingRoad.getName() != null ? climbingRoad.getName() : climbingRoadDTO.getName());
        climbingRoadDTO.setDescription(climbingRoad.getDescription() != null ? climbingRoad.getDescription() : climbingRoadDTO.getDescription());
        climbingRoadDTO.setType(climbingRoad.getType() != null ? climbingRoad.getType() : climbingRoadDTO.getType());
        climbingRoadDTO.setNumber(climbingRoad.getNumber() != 0 ? climbingRoad.getNumber() : climbingRoadDTO.getNumber());
        climbingRoadDTO.setLetter(climbingRoad.getLetter() != ' ' ? climbingRoad.getLetter() : climbingRoadDTO.getLetter());
        climbingRoadDTO.setSymbol(climbingRoad.getSymbol() != ' ' ? climbingRoad.getSymbol() : climbingRoadDTO.getSymbol());

        return climbingRoadDTO;
    }

    public static ClimbingRoad DTOToObject (ClimbingRoadDTO climbingRoadDTO){

        ClimbingRoad climbingRoad = new ClimbingRoad();

        climbingRoad.setName(climbingRoadDTO.getName() != null ? climbingRoadDTO.getName() : climbingRoad.getName());
        climbingRoad.setDescription(climbingRoadDTO.getDescription() != null ? climbingRoadDTO.getDescription() : climbingRoad.getDescription());
        climbingRoad.setType(climbingRoadDTO.getType() != null ? climbingRoadDTO.getType() : climbingRoad.getType());
        climbingRoad.setNumber(climbingRoadDTO.getNumber() != 0 ? climbingRoadDTO.getNumber() : climbingRoad.getNumber());
        climbingRoad.setLetter(climbingRoadDTO.getLetter() != ' ' ? climbingRoadDTO.getLetter() : climbingRoad.getLetter());
        climbingRoad.setSymbol(climbingRoadDTO.getSymbol() != ' ' ? climbingRoadDTO.getSymbol() : climbingRoad.getSymbol());

        return climbingRoad;
    }

}
