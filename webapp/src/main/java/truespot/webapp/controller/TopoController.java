package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.TopoManager;
import truespot.business.dto.TopoDTOContext;
import truespot.model.Topo;
import truespot.business.dto.TopoDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TopoController {

    @Autowired
    private TopoManager topoManager;


    @GetMapping(value="/getAllTopos")
    public List<Topo> getTopos(){
        return topoManager.findAllTopo();
    }

    @RequestMapping(value = "/topo/getByUser/", method = RequestMethod.GET)
    public List<Topo> getTopoByUser(@RequestParam(name = "pseudo", defaultValue = "") String pseudo) {
        return topoManager.findAllByUser_Pseudo(pseudo);
    }

    @RequestMapping(value = "/topo/getByDepartment/", method = RequestMethod.GET)
    public List<Topo> getTopoByDepartment(@RequestParam(name = "id", defaultValue = "") String id) {
        return topoManager.findAllByDepartment_Id(new Long(id));
    }


    @RequestMapping(value = "/topo/getTopo/", method = RequestMethod.GET)
    public TopoDTO getTopo(@RequestParam(name = "id", defaultValue = "") String id) {
        return topoManager.getTopo(new Long(id));
   }

    @RequestMapping(value = "/topo", method = RequestMethod.POST)
    public Topo createTopo(@RequestBody TopoDTOContext topoDTOContext) {
        return topoManager.saveTopo(topoDTOContext);
    }

    @PutMapping(value = "/topo/{id}")
    public void updateTopo(@PathVariable Long id , @RequestBody Topo topo) {
        topoManager.updateTopo(id,topo);

    }

    @DeleteMapping(value= "/topo/{id}")
    public void deleteTopo(@PathVariable Long id){
        topoManager.deleteTopo(id);
    }

}
