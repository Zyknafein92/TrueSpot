package truespot.business.contract;

import org.springframework.data.repository.query.Param;
import truespot.business.dto.AreaDTO;
import truespot.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaManager {

    List<Area> findAllArea();

    List<Area> findAllByIdTopo(Long idTopo);

    List<Area> deleteAreaByTopo(Long id);

    Area getArea(Long id);

    Area saveArea(AreaDTO areaDTO);

    void updateArea(AreaDTO areaDTO);

    void deleteArea(Long idArea);

}
