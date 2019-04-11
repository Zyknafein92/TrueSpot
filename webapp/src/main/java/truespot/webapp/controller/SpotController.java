package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.SpotManager;
import truespot.model.Spot;
import truespot.webapp.dto.SpotDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class SpotController {

    @Autowired
    private SpotManager spotManager;

    @GetMapping(value="/spot")
    public List<Spot> getSpots(){
        return spotManager.findAllSpot();
    }

    @GetMapping(value="/spot/{id}")
    public SpotDTO getSpot(@PathVariable Long id) {
        Optional<Spot> spot = spotManager.getSpot(id);
        if(spot.isPresent()){
            Spot spotReal = spot.get();
            SpotDTO spotDTO = new SpotDTO();

          //  spotDTO.setTopo(spotReal.getTopo());
            spotDTO.setName(spotReal.getName());
            spotDTO.setDescription(spotReal.getDescription());
            spotDTO.setNearestCity(spotReal.getNearestCity());
            spotDTO.setCarAccess(spotReal.getCarAccess());
            spotDTO.setCarParking(spotReal.getCarParking());
            spotDTO.setAccessDescription(spotReal.getAccessDescription());
            spotDTO.setNearestHospital(spotReal.getNearestHospital());
            spotDTO.setSupplyComment(spotReal.getSupplyComment());


            return spotDTO;
        }throw new RuntimeException("spot not found");
    }


    @PostMapping(value="/spot")
    public SpotDTO createSpot(@RequestBody SpotDTO spotDTO){

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
        return spotDTO;
    }


    @PutMapping(value = "/spot/{id}")
    public void updateSpot(@PathVariable Long id , @RequestBody Spot spot) {
        spotManager.updateSpot(id,spot);
    }


    @DeleteMapping(value= "/spot/{id}")
    public void deleteSpot(@PathVariable Long id){
        spotManager.deleteSpot(id);
    }
}
