package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.TopoManager;
import truespot.model.Topo;
import truespot.webapp.dto.TopoDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class TopoController {

    @Autowired
    private TopoManager topoManager;

    @GetMapping(value="/topo")
    public List<Topo> getTopos(){
        return topoManager.findAllTopo();
    }

    @GetMapping(value="/topo/{id}")
    public TopoDTO getTopo(@PathVariable Long id) {
        Optional<Topo> topo = topoManager.getTopo(id);
        if(topo.isPresent()){
            Topo topoReal = topo.get();
            TopoDTO topoDTO = new TopoDTO();

            topoDTO.setName(topoReal.getName());
          //  topoDTO.setUser(topoReal.getUser());
          //  topoDTO.setDepartment(topoReal.getDepartment());


            return topoDTO;
        }throw new RuntimeException("topo not found");
    }


    @PostMapping(value="/topo")
    public TopoDTO createTopo(@RequestBody TopoDTO topoDTO){

        Topo topo = new Topo();

        topo.setName(topoDTO.getName());
     //   topo.setUser(topoDTO.getUser());
     //   topo.setDepartment(topoDTO.getDepartment());


        topo = topoManager.saveTopo(topo);
        topoDTO.setId(topo.getId());
        return topoDTO;
    }


    @PutMapping(value = "/topo/{id}")
    public void updateTopo(@PathVariable Long id , @RequestBody Topo topo) {
        topo.setId(id);
        topoManager.saveTopo(topo);
    }


    @DeleteMapping(value= "/topo/{id}")
    public void deleteTopo(@PathVariable Long id){
        topoManager.deleteTopo(id);
    }

}
