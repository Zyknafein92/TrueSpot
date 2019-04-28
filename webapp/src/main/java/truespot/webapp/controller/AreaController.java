package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.AreaManager;
import truespot.business.dto.mapper.AreaMapper;
import truespot.model.Area;
import truespot.business.dto.AreaDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class AreaController {

    @Autowired
    private AreaManager areaManager;
    @Autowired
    private AreaMapper areaMapper;

    @GetMapping(value="/area")
    public List<Area> getAreas(){
        return areaManager.findAllArea();
    }

    @GetMapping(value="/area/{id}")
    public AreaDTO getArea(@PathVariable Long id) {
        Optional<Area> area = areaManager.getArea(id);
        if(area.isPresent()){
            Area areaReal = area.get();
            return areaMapper.objectToDTO(areaReal);
        }throw new RuntimeException("area not found");
    }


    @PostMapping(value="/area")
    public Area createArea(@RequestBody AreaDTO areaDTO){
        return areaMapper.DTOToObject(areaDTO);
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
