package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.AreaManager;
import truespot.model.Area;
import truespot.business.dto.AreaDTO;

import java.util.List;
import java.util.Optional;

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
        Optional<Area> area = areaManager.getArea(id);
        if(area.isPresent()){
            Area areaReal = area.get();
            AreaDTO areaDTO = new AreaDTO();

            areaDTO.setName(areaReal.getName());
            areaDTO.setDescription(areaReal.getDescription());
            areaDTO.setOrientation(areaReal.getOrientation());
            areaDTO.setRoadNumber(areaReal.getRoadNumber());
            areaDTO.setHeight(areaReal.getHeight());

            return areaDTO;
        }throw new RuntimeException("area not found");
    }


    @PostMapping(value="/area")
    public AreaDTO createArea(@RequestBody AreaDTO areaDTO){

        Area area = new Area();

        area.setName(areaDTO.getName());
        area.setDescription(areaDTO.getDescription());
        area.setOrientation(areaDTO.getOrientation());
        area.setRoadNumber(areaDTO.getRoadNumber());
        area.setHeight(areaDTO.getHeight());

        area = areaManager.saveArea(area);
        areaDTO.setId(area.getId());
        return areaDTO;
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
