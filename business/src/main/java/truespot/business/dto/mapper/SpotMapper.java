package truespot.business.dto.mapper;

import org.springframework.stereotype.Component;
import truespot.business.dto.SpotDTO;
import truespot.model.Spot;

@Component
public class SpotMapper {

    public static SpotDTO objectToDTO (Spot spot) {

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

    public static Spot dtoToObject (SpotDTO spotDTO){

        Spot spot = new Spot();

        spot.setName(spotDTO.getName());
        spot.setDescription(spotDTO.getDescription());
        spot.setNearestCity(spotDTO.getNearestCity());
        spot.setCarAccess(spotDTO.getCarAccess());
        spot.setCarParking(spotDTO.getCarParking());
        spot.setAccessDescription(spotDTO.getAccessDescription());
        spot.setNearestHospital(spotDTO.getNearestHospital());
        spot.setSupplyComment(spotDTO.getSupplyComment());
        spotDTO.setId(spot.getId());

        return spot;
    }

    public static SpotDTO updateDTO (SpotDTO spotDTO, Spot spot) {

        spotDTO.setName(spot.getName() != null ? spot.getName() : spotDTO.getName());
        spotDTO.setDescription(spot.getDescription() != null ? spot.getDescription() : spotDTO.getDescription());
        spotDTO.setNearestCity(spot.getNearestCity() != null ? spot.getNearestCity() : spotDTO.getNearestCity());
        spotDTO.setCarAccess(spot.getCarAccess() != null ? spot.getCarAccess() : spotDTO.getCarAccess());
        spotDTO.setCarParking(spot.getCarParking() != null ? spot.getCarParking() : spotDTO.getCarParking());
        spotDTO.setAccessDescription(spot.getAccessDescription()!= null ? spot.getAccessDescription() : spotDTO.getAccessDescription());
        spotDTO.setNearestHospital(spot.getNearestHospital()!= null ? spot.getNearestHospital() : spotDTO.getNearestHospital());
        spotDTO.setSupplyComment(spot.getSupplyComment()!= null ? spot.getSupplyComment() : spotDTO.getSupplyComment());

        return spotDTO;
    }

}
