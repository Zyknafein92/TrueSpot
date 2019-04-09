package truespot.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.AreaManager;
import truespot.model.Area;

import java.util.List;
import java.util.Optional;

@RestController
public class AreaController {

    @Autowired
    private AreaManager areaManager;

    @GetMapping(value="/area")
    public List<Area> getArea(){
        return areaManager.findAllArea();
    }

    @GetMapping(value="/area/{id}")
    public Optional<Area> getArea(@PathVariable Long id) {
        return areaManager.getArea(id);
    }

    @PostMapping(value="/area")
    public Area createArea(@RequestBody Area Area){
        return areaManager.saveArea(Area);
    }

    @PutMapping(value = "/area/{id}")
    public void updateArea(@PathVariable Long id , @RequestBody Area Area) {
        areaManager.updateArea(id,Area);
    }

    @DeleteMapping(value= "/area/{id}")
    public void deleteArea(@PathVariable Long id){
        areaManager.deleteArea(id);
    }
}
