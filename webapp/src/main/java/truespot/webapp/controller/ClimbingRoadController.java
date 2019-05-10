package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ClimbingRoadManager;
import truespot.business.dto.mapper.ClimbingRoadMapper;
import truespot.model.ClimbingRoad;
import truespot.business.dto.ClimbingRoadDTO;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClimbingRoadController {

    @Autowired
    private ClimbingRoadManager climbingRoadManager;
    @Autowired
    private ClimbingRoadMapper climbingRoadMapper;

    @GetMapping(value="/road")
    public List<ClimbingRoad> getClimbingRoad(){
        return climbingRoadManager.findAllClimbingRoad();
    }

    @GetMapping(value="/road/{id}")
    public ClimbingRoadDTO getClimbingRoad(@PathVariable Long id) {
        Optional<ClimbingRoad> climbingRoad = climbingRoadManager.getClimbingRoad(id);
        if(climbingRoad.isPresent()){
            ClimbingRoad cr = climbingRoad.get();
            return climbingRoadMapper.objectToDTO(cr);
        } throw new RuntimeException("ClimbingRoad not found");
    }

    @PostMapping(value="/road")
    public ClimbingRoad createClimbingRoad(@RequestBody ClimbingRoadDTO climbingRoadDTO){
        return climbingRoadMapper.DTOToObject(climbingRoadDTO);
    }


    @PutMapping(value = "/road/{id}")
    public void updateClimbingRoad(@PathVariable Long id , @RequestBody ClimbingRoad climbingRoad) {
        climbingRoadManager.updateClimbingRoad(id,climbingRoad);
    }


    @DeleteMapping(value= "/road/{id}")
    public void deleteClimbingRoad(@PathVariable Long id){ climbingRoadManager.deleteClimbingRoad(id); }
}
