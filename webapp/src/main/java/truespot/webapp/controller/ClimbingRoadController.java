package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ClimbingRoadManager;
import truespot.business.dto.TopoDTO;
import truespot.model.ClimbingRoad;
import truespot.business.dto.ClimbingRoadDTO;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClimbingRoadController {

    @Autowired
    private ClimbingRoadManager climbingRoadManager;


    @GetMapping(value="/road")
    public List<ClimbingRoad> getClimbingRoad(){
        return climbingRoadManager.findAllClimbingRoad();
    }

//    @GetMapping(value="/road/{id}")
//    public ClimbingRoadDTO getClimbingRoad(@PathVariable Long id) {
//            return climbingRoadManager.getClimbingRoad(id);
//    }

    @RequestMapping(value = "/road/getRoad", method = RequestMethod.GET)
    public ClimbingRoadDTO getRoad(@RequestParam(name = "id", defaultValue = "") String id) {
        return climbingRoadManager.getClimbingRoad(new Long(id));
    }

    @PostMapping(value="/road")
    public ClimbingRoad createClimbingRoad(@RequestBody ClimbingRoadDTO climbingRoadDTO){
        return climbingRoadManager.saveClimbingRoad(climbingRoadDTO);
    }

    @PutMapping(value = "/road/{id}")
    public void updateClimbingRoad(@PathVariable Long id , @RequestBody ClimbingRoad climbingRoad) {
        climbingRoadManager.updateClimbingRoad(id,climbingRoad);
    }

    @DeleteMapping(value= "/road/{id}")
    public void deleteClimbingRoad(@PathVariable Long id){ climbingRoadManager.deleteClimbingRoad(id); }
}
