package truespot.business.dto.mapper;

import org.springframework.stereotype.Component;
import truespot.business.dto.AreaDTO;
import truespot.model.Area;

@Component
public class AreaMapper {

    public static AreaDTO objectToDTO (Area area){

        AreaDTO areaDTO = new AreaDTO();

        areaDTO.setName(area.getName());
        areaDTO.setDescription(area.getDescription());
        areaDTO.setOrientation(area.getOrientation());
        areaDTO.setRoadNumber(area.getRoadNumber());
        areaDTO.setHeight(area.getHeight());

        return areaDTO;
    }

    public static Area DTOToObject (AreaDTO areaDTO) {

        Area area = new Area();

        area.setName(areaDTO.getName());
        area.setDescription(areaDTO.getDescription());
        area.setOrientation(areaDTO.getOrientation());
        area.setRoadNumber(areaDTO.getRoadNumber());
        area.setHeight(areaDTO.getHeight());

       // area = areaManager.saveArea(area);
        areaDTO.setId(area.getId()); //todo : a retirer ? si id non utiluser
        return area;
    }

    public static AreaDTO updateDTO (AreaDTO areaDTO, Area area) {

        areaDTO.setName(area.getName() != null ? area.getName() : areaDTO.getName());

        return areaDTO;
    }
}
