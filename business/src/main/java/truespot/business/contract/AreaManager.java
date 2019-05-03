package truespot.business.contract;

import truespot.business.dto.AreaDTO;
import truespot.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaManager {

    List<Area> findAllArea();

    AreaDTO getArea(Long id);

    Area saveArea(AreaDTO areaDTO);

    void updateArea(Long id, Area area);

    void deleteArea(Long id);

}
