package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.ClimbingRoadTypeManager;
import truespot.model.ClimbingRoadType;
import truespot.business.dto.ClimbingRoadTypeDTO;


import java.util.Optional;

@RestController
public class ClimbingRoadTypeController {

    @Autowired
    private ClimbingRoadTypeManager climbingRoadTypeManager;


    @GetMapping(value="/roadType/{id}")
    public ClimbingRoadTypeDTO getClimbingRoadType(@PathVariable Long id){

        Optional<ClimbingRoadType> climbingRoadType = climbingRoadTypeManager.getClimbingRoadType(id);

        if(climbingRoadType.isPresent()){
            ClimbingRoadType crType = climbingRoadType.get();
            ClimbingRoadTypeDTO climbingRoadTypeDTO = new ClimbingRoadTypeDTO();

            climbingRoadTypeDTO.setId(crType.getId());
            climbingRoadTypeDTO.setName(crType.getName());
            return climbingRoadTypeDTO;
        }throw new RuntimeException("ClimbingRoadType not found");

    }

    @PostMapping(value="/roadType")
    public ClimbingRoadTypeDTO createClimbingRoadType(@RequestBody ClimbingRoadTypeDTO climbingRoadTypeDTO){

        ClimbingRoadType climbingRoadType = new ClimbingRoadType();

        climbingRoadType.setName(climbingRoadTypeDTO.getName());
        climbingRoadType = climbingRoadTypeManager.saveClimbingRoadType(climbingRoadType);
        climbingRoadTypeDTO.setId(climbingRoadType.getId());

        return climbingRoadTypeDTO;

    }

    @PutMapping(value="/roadType/{id}")
    public void updateClimbingRoadType(@PathVariable Long id, @RequestBody ClimbingRoadType climbingRoadType){
        climbingRoadTypeManager.updateClimbingRoadType(id,climbingRoadType);
    }

    @DeleteMapping(value="/roadType/{id}")
    public void deleteClimbingRoadType(@PathVariable Long id){
        climbingRoadTypeManager.deleteClimbingRoadType(id);
    }
}
