package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.TopoManager;
import truespot.business.contract.UserManager;
import truespot.business.dto.TopoDTO;
import truespot.model.Topo;

@Component
public class TopoMapper {

    @Autowired
    private TopoManager topoManager;
    @Autowired
    private UserManager userManager;

    public TopoDTO objectToDTO (Topo topo) {

        TopoDTO topoDTO = new TopoDTO();

        topoDTO.setName(topo.getName());
        topoDTO.setDepartment(topo.getDepartment());

        return topoDTO;
    }

    public Topo dtoToObject (TopoDTO topoDTO){

        Topo topo = new Topo();

       // topo.setUser(topoDTO.setUser()));
        topo.setName(topoDTO.getName());
        topo.setDepartment(topoDTO.getDepartment());

        topo = topoManager.saveTopo(topo);
        topoDTO.setId(topoDTO.getId());
        return topo;
    }
}
