package truespot.business.contract;

import truespot.business.dto.SpotDTO;
import truespot.model.Spot;

import java.util.List;

public interface SpotManager {

    List<Spot> findAllSpot();

    SpotDTO getSpot(Long id);

    Spot saveSpot(SpotDTO spotDTO);

    void updateSpot(Long id, Spot spot);

    void deleteSpot(Long id);
}
