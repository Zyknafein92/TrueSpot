package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.AreaManager;
import truespot.business.dto.AreaDTO;
import truespot.model.Area;

@Component
public class AreaMapper {

    @Autowired
    private AreaManager areaManager;

    public AreaDTO objectToDTO (Area area){

        AreaDTO areaDTO = new AreaDTO();

        areaDTO.setName(area.getName());
        areaDTO.setDescription(area.getDescription());
        areaDTO.setOrientation(area.getOrientation());
        areaDTO.setRoadNumber(area.getRoadNumber());
        areaDTO.setHeight(area.getHeight());

        return areaDTO;
    }

    public Area DTOToObject (AreaDTO areaDTO){

        Area area = new Area();

        area.setName(areaDTO.getName());
        area.setDescription(areaDTO.getDescription());
        area.setOrientation(areaDTO.getOrientation());
        area.setRoadNumber(areaDTO.getRoadNumber());
        area.setHeight(areaDTO.getHeight());

        area = areaManager.saveArea(area);
        areaDTO.setId(area.getId());
        return area;
    }
}
