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
    @RequestMapping(value = "/topo/getByDepartment", method = RequestMethod.GET)
    public List<Topo> getTopoByDepartment(@RequestParam(name = "idDepartment", defaultValue = "") String idDepartment) {
        return topoManager.findAllByDepartment_Id(Long.valueOf(idDepartment));
    }

    @RequestMapping(value = "/topo/search", method = RequestMethod.GET)
    public List<Topo> getTopoBySearch(
            @RequestParam(name = "idDepartment", defaultValue = "") String idDepartment,
            @RequestParam(name = "avaible", defaultValue = "") String avaible,
            @RequestParam(name = "type", defaultValue = "") String type
    ) {
        return topoManager.searchCriteres(Long.valueOf(idDepartment),avaible, type);
    }

    @RequestMapping(value = "/topo/getAllShareTopoByUser", method = RequestMethod.GET)
    public List<Topo> getAllShareToByUser(@RequestParam(name = "id", defaultValue = "") String id) {
        return topoManager.findAllShareTopoByUser(new Long(id));
    }

    @RequestMapping(value = "/topo/getTopo", method = RequestMethod.GET)
    public TopoDTO getTopo(@RequestParam(name = "id", defaultValue = "") String id) {
        return topoManager.getTopo(new Long(id));
    }

    @RequestMapping(value = "/topo", method = RequestMethod.POST)
    public Topo createTopo(@RequestBody TopoDTOContext topoDTOContext) {
        return topoManager.saveTopo(topoDTOContext);
    }



    @RequestMapping(value = "/topo/update", method = RequestMethod.PUT)
    public void updateTopo(@RequestBody TopoDTO topoDTO) {
        topoManager.updateTopo(topoDTO);

    }

    @RequestMapping(value = "/topo/shareUpdate", method = RequestMethod.PUT)
    public void updateShareTopo(@RequestBody TopoDTO topoDTO) {
        topoManager.updateShareTopo(topoDTO);
    }

    @RequestMapping(value = "/topo/delete", method = RequestMethod.DELETE)
    public void deleteArea(@RequestParam(name = "idTopo", defaultValue = "")  String idTopo){
        topoManager.deleteTopo(Long.valueOf(idTopo));
    }

}
