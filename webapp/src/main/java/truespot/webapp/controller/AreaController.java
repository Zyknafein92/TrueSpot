package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.AreaManager;
import truespot.business.dto.mapper.AreaMapper;
import truespot.model.Area;
import truespot.business.dto.AreaDTO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AreaController {

    @Autowired
    private AreaManager areaManager;

    @GetMapping(value="/area")
    public List<Area> getAreas(){
        return areaManager.findAllArea();
    }

    @GetMapping(value="/area/{id}")
    public AreaDTO getArea(@PathVariable Long id) {
        return areaManager.getArea(id);
    }


    @PostMapping(value="/area")
    public Area createArea(@RequestBody AreaDTO areaDTO){
        return areaManager.saveArea(areaDTO);
    }


    @PutMapping(value = "/area/{id}")
    public void updateArea(@PathVariable Long id , @RequestBody Area area) {
        areaManager.updateArea(id,area);
    }


    @DeleteMapping(value= "/area/{id}")
    public void deleteArea(@PathVariable Long id){
        areaManager.deleteArea(id);
    }
}
