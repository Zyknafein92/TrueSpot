package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.SpotManager;
import truespot.business.dto.SpotDTO;
import truespot.model.Spot;

@Component
public class SpotMapper {

    @Autowired
    private SpotManager spotManager;

    public SpotDTO objectToDTO (Spot spot) {

        SpotDTO spotDTO = new SpotDTO();

        spotDTO.setName(spot.getName());
        spotDTO.setDescription(spot.getDescription());
        spotDTO.setNearestCity(spot.getNearestCity());
        spotDTO.setCarAccess(spot.getCarAccess());
        spotDTO.setCarParking(spot.getCarParking());
        spotDTO.setAccessDescription(spot.getAccessDescription());
        spotDTO.setNearestHospital(spot.getNearestHospital());
        spotDTO.setSupplyComment(spot.getSupplyComment());

        return spotDTO;
    }

    public Spot dtoToObject (SpotDTO spotDTO){
        Spot spot = new Spot();

        spot.setName(spotDTO.getName());
        spot.setDescription(spotDTO.getDescription());
        spot.setNearestCity(spotDTO.getNearestCity());
        spot.setCarAccess(spotDTO.getCarAccess());
        spot.setCarParking(spotDTO.getCarParking());
        spot.setAccessDescription(spotDTO.getAccessDescription());
        spot.setNearestHospital(spotDTO.getNearestHospital());
        spot.setSupplyComment(spotDTO.getSupplyComment());

        spot = spotManager.saveSpot(spot);
        spotDTO.setId(spot.getId());
        return spot;
    }

}
