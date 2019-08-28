package truespot.business.contract;

import truespot.business.dto.AreaDTO;
import truespot.model.Area;

import java.util.List;

public interface AreaManager {

    List<Area> findAllArea();

    List<Area> findAllByIdTopo(Long idTopo);

    List<Area> deleteAreaByTopo(Long id);

    Area getArea(Long id);

    Area saveArea(AreaDTO areaDTO);

    void updateArea(AreaDTO areaDTO);

    void deleteArea(Long idArea);

}
