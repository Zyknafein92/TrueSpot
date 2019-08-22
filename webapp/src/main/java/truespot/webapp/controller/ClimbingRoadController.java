package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ClimbingRoadManager;
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


    @RequestMapping(value = "/road/getAllByArea", method = RequestMethod.GET)
    public List<ClimbingRoad> getAllByArea(@RequestParam(name = "idArea", defaultValue = "")  String idArea){
        return climbingRoadManager.findAllClimbingRoadByIdArea(Long.valueOf(idArea));
    }

    @RequestMapping(value = "/road/getRoad", method = RequestMethod.GET)
    public ClimbingRoad getRoad(@RequestParam(name = "idArea", defaultValue = "") String idArea) {
        return climbingRoadManager.getClimbingRoad(Long.valueOf(idArea));
    }

    @PostMapping(value="/road")
    public ClimbingRoad createClimbingRoad(@RequestBody ClimbingRoadDTO climbingRoadDTO){
        return climbingRoadManager.saveClimbingRoad(climbingRoadDTO);
    }

    @PutMapping(value = "/road/{id}")
    public void updateClimbingRoad(@RequestBody ClimbingRoadDTO climbingRoadDTO) {
        climbingRoadManager.updateClimbingRoad(climbingRoadDTO);
    }
    @RequestMapping(value = "/road", method = RequestMethod.DELETE)
    public void deleteClimbingRoad(@RequestParam(name = "idRoad", defaultValue = "") String idRoad){ climbingRoadManager.deleteClimbingRoad(Long.valueOf(idRoad)); }
}
