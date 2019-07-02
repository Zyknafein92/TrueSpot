package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.TopoManager;
import truespot.business.contract.UserManager;
import truespot.business.dto.TopoDTO;
import truespot.model.Topo;

@Component
public class TopoMapper {


    public static TopoDTO objectToDTO (Topo topo) {

        TopoDTO topoDTO = new TopoDTO();

        topoDTO.setName(topo.getName());
        topoDTO.setUser(topo.getUser());
        topoDTO.setDepartment(topo.getDepartment());

        return topoDTO;
    }

    public static Topo dtoToObject (TopoDTO topoDTO){

        Topo topo = new Topo();

        topo.setName(topoDTO.getName());
        topo.setDepartment(topoDTO.getDepartment());
        topoDTO.setId(topoDTO.getId());

        return topo;
    }

    public static TopoDTO updateDTO(TopoDTO topoDTO, Topo topo) {

        topoDTO.setName(topo.getName() != null ? topo.getName() : topoDTO.getName());
        topoDTO.setUser(topo.getUser() != null ? topo.getUser() : topoDTO.getUser());
        topoDTO.setDepartment(topo.getDepartment() != null ? topo.getDepartment() : topoDTO.getDepartment());

        return topoDTO;

    }
}
