package truespot.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ClimbingRoadManager;
import truespot.model.ClimbingRoad;

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
    public Optional<ClimbingRoad> getClimbingRoad(@PathVariable Long id) {
        return climbingRoadManager.getClimbingRoad(id);
    }

    @PostMapping(value="/road")
    public ClimbingRoad createClimbingRoad(@RequestBody ClimbingRoad climbingRoad){
        return climbingRoadManager.saveClimbingRoad(climbingRoad);
    }

    //todo a rework
    @PutMapping(value = "/road/{id}")
    public void updateClimbingRoad(@PathVariable Long id , @RequestBody ClimbingRoad climbingRoad) {
        climbingRoadManager.updateClimbingRoad(id,climbingRoad); }


    @DeleteMapping(value= "/road/{id}")
    public void deleteClimbingRoad(@PathVariable Long id){ climbingRoadManager.deleteClimbingRoad(id); }
}
