package truespot.business.dto.mapper;

import org.springframework.stereotype.Component;
import truespot.business.dto.AreaDTO;
import truespot.model.Area;

@Component
public class AreaMapper {

    public static AreaDTO objectToDTO (Area area){

        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setId(area.getId() != 0 ? area.getId() : areaDTO.getId());
        areaDTO.setName(area.getName() != null ? area.getName() : areaDTO.getName());
        areaDTO.setDescription(area.getDescription() != null ? area.getDescription() : areaDTO.getDescription());
        areaDTO.setOrientation(area.getOrientation() != null ? area.getOrientation() : areaDTO.getOrientation());
        areaDTO.setHeight(area.getHeight() != 0 ? area.getHeight() : areaDTO.getHeight());

        return areaDTO;
    }

    public static Area DTOToObject (AreaDTO areaDTO) {

        Area area = new Area();

        area.setName(areaDTO.getName() != null ? areaDTO.getName() : area.getName());
        area.setDescription(areaDTO.getDescription() != null ? areaDTO.getName() : area.getName());
        area.setOrientation(areaDTO.getOrientation() != null ? areaDTO.getOrientation() : area.getOrientation());
        area.setHeight(areaDTO.getHeight() != 0 ? areaDTO.getHeight() : area.getHeight());
        areaDTO.setId(area.getId());

        return area;
    }

    public static AreaDTO updateDTO (AreaDTO areaDTO, Area area) {

        areaDTO.setName(area.getName() != null ? area.getName() : areaDTO.getName());
        areaDTO.setDescription(area.getDescription()!= null ? area.getDescription() : areaDTO.getDescription());
        areaDTO.setOrientation(area.getOrientation()!= null ? area.getOrientation() : areaDTO.getOrientation());
        areaDTO.setHeight(area.getHeight()!= 0 ? area.getHeight() : areaDTO.getHeight());

        return areaDTO;
    }
}
