package truespot.business.contract;

import truespot.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaManager {

    List<Area> findAllArea();

    Optional<Area> getArea(Long id);

    Area saveArea(Area area);

    void updateArea(Long id, Area area);

    void deleteArea(Long id);

}
