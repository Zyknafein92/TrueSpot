package truespot.business.dto.mapper;


import org.springframework.stereotype.Component;
import truespot.business.dto.TopoDTO;
import truespot.model.Topo;


@Component
public class TopoMapper {


    public static TopoDTO objectToDTO (Topo topo) {

        TopoDTO topoDTO = new TopoDTO();

        topoDTO.setId(topo.getId() != null ? topo.getId() : topoDTO.getId());
        topoDTO.setName(topo.getName() != null ? topo.getName() : topoDTO.getName());
        topoDTO.setUser(topo.getUser() != null ? UserMapper.objectToDTO(topo.getUser()) : null);
        topoDTO.setDepartment(topo.getDepartment() != null ? DepartmentMapper.objectToDTO(topo.getDepartment()) : null);
        topoDTO.setDescription(topo.getDescription() != null ? topo.getDescription() : topoDTO.getDescription());
        topoDTO.setNearestCity(topo.getNearestCity() != null ? topo.getNearestCity() : topoDTO.getNearestCity());
        topoDTO.setCarAccess(topo.getCarAccess() != null ? topo.getCarAccess() : topoDTO.getCarAccess());
        topoDTO.setCarParking(topo.getCarParking() != null ? topo.getCarParking() : topoDTO.getCarParking());
        topoDTO.setAccessDescription(topo.getAccessDescription() != null ? topo.getAccessDescription() : topoDTO.getAccessDescription());
        topoDTO.setNearestHospital(topo.getNearestHospital() != null ? topo.getNearestHospital() : topoDTO.getNearestHospital());
        topoDTO.setSupplyComment(topo.getSupplyComment() != null ? topo.getSupplyComment() : topoDTO.getSupplyComment());
        topoDTO.setAvaible(topo.getAvaible() != null ? topo.getAvaible() : topoDTO.getAvaible());
        topoDTO.setReleaseDate(topo.getReleaseDate() != null ? topo.getReleaseDate() : topoDTO.getReleaseDate());

        return topoDTO;
    }

    public static Topo dtoToObject (TopoDTO topoDTO) {

        Topo topo = new Topo();


        topo.setName(topoDTO.getName() != null ? topoDTO.getName() : topo.getName());
        topo.setUser(topoDTO.getUser() != null ? UserMapper.dtoToObject(topoDTO.getUser()) : null);
        topo.setDepartment(topoDTO.getDepartment() != null ? DepartmentMapper.DTOToObject(topoDTO.getDepartment()) : null);
        topo.setDescription(topoDTO.getDescription() != null ? topoDTO.getDescription() : topo.getDescription());
        topo.setNearestCity(topoDTO.getNearestCity() != null ? topoDTO.getNearestCity() : topo.getNearestCity());
        topo.setCarAccess(topoDTO.getCarAccess() != null ? topoDTO.getCarAccess() : topo.getCarAccess());
        topo.setCarParking(topoDTO.getCarParking() != null ? topoDTO.getCarParking() : topo.getCarParking());
        topo.setAccessDescription(topoDTO.getAccessDescription() != null ? topoDTO.getAccessDescription() : topo.getAccessDescription());
        topo.setNearestHospital(topoDTO.getNearestHospital() != null ? topoDTO.getNearestHospital() : topo.getNearestHospital());
        topo.setSupplyComment(topoDTO.getSupplyComment() != null ? topoDTO.getSupplyComment() : topo.getSupplyComment());
        topo.setAvaible(topoDTO.getAvaible() != null ? topoDTO.getAvaible() : topo.getAvaible());
        topo.setReleaseDate(topoDTO.getReleaseDate() != null ? topoDTO.getReleaseDate() : topo.getReleaseDate());
        topo.setId(topoDTO.getId());

        return topo;
    }

}
