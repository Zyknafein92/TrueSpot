package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.AreaManager;
import truespot.business.contract.DepartmentManager;
import truespot.business.contract.TopoManager;
import truespot.business.dto.TopoDTO;
import truespot.business.dto.TopoDTOContext;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.DepartmentMapper;
import truespot.business.dto.mapper.TopoMapper;
import truespot.business.dto.mapper.UserMapper;
import truespot.model.Area;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

import java.util.*;


@Service
public class TopoManagerImpl extends BusinessManagerImpl implements TopoManager {

    @Autowired
    DepartmentManager departmentManager;
    @Autowired
    AreaManager areaManager;

    @Override
    public List<Topo> findAllTopo() {
        return getDaoFactory().getTopoRepository().findAll();
    }

    @Override
    public List<Topo> findAllByUser_Pseudo(String pseudo) {
        return getDaoFactory().getTopoRepository().findAllByUser_Pseudo(pseudo);
    }

    @Override
    public List<Topo> findAllByDepartment_Id(Long id) {
        return getDaoFactory().getTopoRepository().findAllByDepartment_Id(id);
    }

    @Override
    public List<Topo> findAllShareTopoByUser(Long id) {
        return getDaoFactory().getTopoRepository().findAllShareToByUser(id);
    }


    @Override
    public TopoDTO getTopo(Long id) {

        Optional<Topo> topoOptional = getDaoFactory().getTopoRepository().findById(id);

        Topo topo = null;

        if(topoOptional.isPresent()){
            topo = new Topo(
                    topoOptional.get().getId(),
                    topoOptional.get().getName(),
                    topoOptional.get().getUser(),
                    topoOptional.get().getDepartment(),
                    topoOptional.get().getReleaseDate(),
                    topoOptional.get().getDescription(),
                    topoOptional.get().getNearestCity(),
                    topoOptional.get().getCarAccess(),
                    topoOptional.get().getCarParking(),
                    topoOptional.get().getAccessDescription(),
                    topoOptional.get().getNearestHospital(),
                    topoOptional.get().getSupplyComment(),
                    topoOptional.get().getAvaible()
            );
        }

        return topo != null ? TopoMapper.objectToDTO(topo) : null;
    }

    @Override
    public Topo saveTopo(TopoDTOContext topoDTOContext) {


        User user = getDaoFactory().getUserRepository().findByPseudo(topoDTOContext.getUserPseudo());
        Department department = getDaoFactory().getDepartmentRepository().getOne(topoDTOContext.getIdDepartment());

        TopoDTO topoDTO = new TopoDTO();

        topoDTO.setName(topoDTOContext.getName());
        topoDTO.setReleaseDate(new Date());

        UserDTO userDTO = UserMapper.objectToDTO(user);
        topoDTO.setUser(userDTO);
        topoDTO.getUser().setRoles(new HashSet<>());
        topoDTO.setDepartment(DepartmentMapper.objectToDTO(department));
        topoDTO.setDescription(topoDTOContext.getDescription());
        topoDTO.setNearestCity(topoDTOContext.getNearestCity());
        topoDTO.setCarAccess(topoDTOContext.getCarAccess());
        topoDTO.setCarParking(topoDTOContext.getCarParking());
        topoDTO.setAccessDescription(topoDTOContext.getAccessDescription());
        topoDTO.setNearestHospital(topoDTOContext.getNearestHospital());
        topoDTO.setSupplyComment(topoDTOContext.getSupplyComment());
        topoDTO.setAvaible("DISPONIBLE");

        Topo topo = TopoMapper.dtoToObject(topoDTO);
        topo.setUser(user);


        return getDaoFactory().getTopoRepository().save(topo);
    }


    @Override
    public void updateTopo(TopoDTO topoDTO) {
        User user = getDaoFactory().getUserRepository().findByPseudo(topoDTO.getUser().getPseudo());
        Department department = getDaoFactory().getDepartmentRepository().getOne(topoDTO.getDepartment().getId());

        topoDTO.setDepartment(DepartmentMapper.objectToDTO(department));
        topoDTO.setUser(UserMapper.objectToDTO(user));
        topoDTO.getUser().setRoles(new HashSet<>());

        Topo topo = TopoMapper.dtoToObject(topoDTO);
        topo.setId(topoDTO.getId());
        topo.setReleaseDate(topoDTO.getReleaseDate());

        getDaoFactory().getTopoRepository().save(topo);
    }

    @Override
    public void updateShareTopo(TopoDTO topoDTO) {
        Topo topo = getDaoFactory().getTopoRepository().getOne(topoDTO.getId());
        topo.setAvaible("INDISPONIBLE");
        getDaoFactory().getTopoRepository().save(topo);
    }

    @Override
    public void deleteTopo(Long id) {

        List<Area> areas = getDaoFactory().getAreaRepository().findAllByTopo(id);
        if(areas.size() > 0){
            for (Area area: areas) {
             Area areaDelete = getDaoFactory().getAreaRepository().getOne(area.getId());
                areaManager.deleteArea(areaDelete.getId());
            }
        }

        getDaoFactory().getTopoRepository().delete(getDaoFactory().getTopoRepository().getOne(id));
    }
}
