package truespot.business.contract;

import truespot.model.Spot;

import java.util.List;
import java.util.Optional;

public interface SpotManager {

    List<Spot> findAllSpot();

    Optional<Spot> getSpot(Long id);

    Spot saveSpot(Spot spot);

    void updateSpot(Long id, Spot spot);

    void deleteSpot(Long id);
}
