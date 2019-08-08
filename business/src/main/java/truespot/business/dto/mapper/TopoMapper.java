package truespot.business.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import truespot.business.contract.TopoManager;
import truespot.business.contract.UserManager;
import truespot.business.dto.DepartmentDTO;
import truespot.business.dto.TopoDTO;
import truespot.business.dto.UserDTO;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

@Component
public class TopoMapper {


    public static TopoDTO objectToDTO (Topo topo) {

        TopoDTO topoDTO = new TopoDTO();

        topoDTO.setName(topo.getName() != null ? topo.getName() : topoDTO.getName());
        topoDTO.setUser(topo.getUser() != null ? UserMapper.objectToDTO(topo.getUser()) : null);
        topoDTO.setDepartment(topo.getDepartment() != null ? DepartmentMapper.objectToDTO(topo.getDepartment()) : null);

        return topoDTO;
    }

    public static Topo dtoToObject (TopoDTO topoDTO) {

        Topo topo = new Topo();


        topo.setName(topoDTO.getName() != null ? topoDTO.getName() : topo.getName());
        topo.setUser(topoDTO.getUser() != null ? UserMapper.dtoToObject(topoDTO.getUser()) : null);
     //   topo.setDepartment(topoDTO.getDepartment() != null ? topoDTO.getDepartment() : topo.getDepartment());
        topo.setDepartment(topoDTO.getDepartment() != null ? DepartmentMapper.DTOToObject(topoDTO.getDepartment()) : null);
        topoDTO.setId(topo.getId());

        return topo;
    }

    public static TopoDTO updateDTO(TopoDTO topoDTO, Topo topo) {

        topoDTO.setName(topo.getName() != null ? topo.getName() : topoDTO.getName());
        topoDTO.setUser(topo.getUser() != null ? UserMapper.objectToDTO(topo.getUser()) : null);
        topoDTO.setDepartment(topo.getDepartment() != null ? DepartmentMapper.objectToDTO(topo.getDepartment()) : null);

        return topoDTO;

    }
}
