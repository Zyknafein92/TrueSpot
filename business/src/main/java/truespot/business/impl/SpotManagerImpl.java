package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.SpotManager;
import truespot.model.Spot;

import java.util.List;
import java.util.Optional;

@Service
public class SpotManagerImpl extends BusinessManagerImpl implements SpotManager {

    @Override
    public List<Spot> findAllSpot() {
        return getDaoFactory().getSpotRepository().findAll();
    }

    @Override
    public Optional<Spot> getSpot(Long id) {
        return getDaoFactory().getSpotRepository().findById(id);
    }

    @Override
    public Spot saveSpot(Spot spot) {
        return getDaoFactory().getSpotRepository().save(spot);
    }

    @Override
    public void updateSpot(Long id, Spot spot) {
        spot.setId(id);
        getDaoFactory().getSpotRepository().save(spot);
    }

    @Override
    public void deleteSpot(Long id) {
      getDaoFactory().getSpotRepository().deleteById(id);
    }
}
