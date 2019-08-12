package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.SpotManager;
import truespot.business.dto.SpotDTO;
import truespot.business.dto.mapper.SpotMapper;
import truespot.business.dto.mapper.TopoMapper;
import truespot.model.Spot;
import truespot.model.Topo;

import java.util.List;
import java.util.Optional;


@Service
public class SpotManagerImpl extends BusinessManagerImpl implements SpotManager {

    @Override
    public List<Spot> findAllSpot() {
        return getDaoFactory().getSpotRepository().findAll();
    }

    @Override
    public SpotDTO getSpot(Long id) {

        Optional<Spot> spotOptional = getDaoFactory().getSpotRepository().findById(id);
        Spot spot = null;

        if(spotOptional.isPresent()){
            spot = new Spot(
            spotOptional.get().getName(),
            spotOptional.get().getDescription(),
            spotOptional.get().getNearestCity(),
            spotOptional.get().getCarAccess(),
            spotOptional.get().getCarParking(),
            spotOptional.get().getAccessDescription(),
            spotOptional.get().getNearestHospital(),
            spotOptional.get().getSupplyComment()
            );
        }
        return spot != null ? SpotMapper.objectToDTO(spot) : null;
    }

    @Override
    public Spot saveSpot(SpotDTO spotDTO) {
        Topo topo = getDaoFactory().getTopoRepository().getOne(new Long(spotDTO.getIdTopo()));
        Spot spot = SpotMapper.dtoToObject(spotDTO);
        spot.setTopo(topo);
        return getDaoFactory().getSpotRepository().save(spot);
    }

    @Override
    public void updateSpot(Long id, Spot spot) {
        SpotDTO spotDTO = getSpot(id);
        SpotMapper.updateDTO(spotDTO, spot);
        spot.setId(id);
        getDaoFactory().getSpotRepository().save(spot);
    }

    @Override
    public void deleteSpot(Long id) {
      getDaoFactory().getSpotRepository().deleteById(id);
    }
}
