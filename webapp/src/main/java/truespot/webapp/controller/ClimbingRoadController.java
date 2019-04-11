package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ClimbingRoadManager;
import truespot.model.ClimbingRoad;
import truespot.webapp.dto.ClimbingRoadDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class ClimbingRoadController {

    @Autowired
    private ClimbingRoadManager climbingRoadManager;

    @GetMapping(value="/road")
    public List<ClimbingRoad> getClimbingRoad(){
        return climbingRoadManager.findAllClimbingRoad();
    }

    @GetMapping(value="/road/{id}")
    public ClimbingRoadDTO getClimbingRoad(@PathVariable Long id) {

        Optional<ClimbingRoad> climbingRoad = climbingRoadManager.getClimbingRoad(id);
        if(climbingRoad.isPresent()){

            ClimbingRoad cr = climbingRoad.get();
            ClimbingRoadDTO climbingRoadDTO = new ClimbingRoadDTO();

            climbingRoadDTO.setId(cr.getId());
            climbingRoadDTO.setName(cr.getName());
            climbingRoadDTO.setDescription(cr.getDescription());

            return climbingRoadDTO;
        } throw new RuntimeException("ClimbingRoad not found");
    }

    @PostMapping(value="/road")
    public ClimbingRoadDTO createClimbingRoad(@RequestBody ClimbingRoadDTO climbingRoadDTO){

        ClimbingRoad climbingRoad = new ClimbingRoad();

        climbingRoad.setName(climbingRoadDTO.getName());
        climbingRoad.setDescription(climbingRoadDTO.getDescription());

        climbingRoad = climbingRoadManager.saveClimbingRoad(climbingRoad);
        climbingRoadDTO.setId(climbingRoad.getId());

        return climbingRoadDTO;
    }


    @PutMapping(value = "/road/{id}")
    public void updateClimbingRoad(@PathVariable Long id , @RequestBody ClimbingRoad climbingRoad) {
        climbingRoadManager.updateClimbingRoad(id,climbingRoad);
    }


    @DeleteMapping(value= "/road/{id}")
    public void deleteClimbingRoad(@PathVariable Long id){ climbingRoadManager.deleteClimbingRoad(id); }
}
