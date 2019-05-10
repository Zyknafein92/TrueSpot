package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.TopoManager;
import truespot.business.dto.mapper.TopoMapper;
import truespot.model.Topo;
import truespot.business.dto.TopoDTO;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TopoController {

    @Autowired
    private TopoManager topoManager;
    @Autowired
    private TopoMapper topoMapper;

    @GetMapping(value="/topo")
    public List<Topo> getTopos(){
        return topoManager.findAllTopo();
    }

    @GetMapping(value="/topo/{id}")
    public TopoDTO getTopo(@PathVariable Long id) {
        Optional<Topo> topo = topoManager.getTopo(id);
        if(topo.isPresent()) {
            Topo topoR = topo.get();
            return topoMapper.objectToDTO(topoR);
        }throw new RuntimeException("topo not found");
    }


    @PostMapping(value="/topo")
    public Topo createTopo(@RequestBody TopoDTO topoDTO){
        return topoMapper.dtoToObject(topoDTO);
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
