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

//    @GetMapping(value="/areas")
//    public List<Area> getAreas(){
//        return areaManager.findAllArea();
//    }

    @RequestMapping(value = "/area/getByID", method = RequestMethod.GET)
    public Area getArea(@RequestParam(name = "idArea", defaultValue = "")  String idArea) {
        return areaManager.getArea(Long.valueOf(idArea));
    }

    @RequestMapping(value = "/area/getAllByTopo", method = RequestMethod.GET)
    public List<Area> getAllByTopo(@RequestParam(name = "idTopo", defaultValue = "")  String idTopo){
        return areaManager.findAllByIdTopo(Long.valueOf(idTopo));
    }


    @PostMapping(value="/area")
    public Area createArea(@RequestBody AreaDTO areaDTO){
        return areaManager.saveArea(areaDTO);
    }


    @RequestMapping(value = "/area/update", method = RequestMethod.PUT)
    public void updateClimbingRoad(@RequestBody AreaDTO areaDTO) {
        areaManager.updateArea(areaDTO);
    }


    @RequestMapping(value = "/area/delete", method = RequestMethod.DELETE)
    public void deleteArea(@RequestParam(name = "idArea", defaultValue = "")  String idArea){
        areaManager.deleteArea(Long.valueOf(idArea));
    }
}
