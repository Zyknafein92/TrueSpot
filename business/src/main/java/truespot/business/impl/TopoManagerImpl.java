package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.TopoManager;
import truespot.business.dto.TopoDTO;
import truespot.business.dto.TopoDTOContext;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.DepartmentMapper;
import truespot.business.dto.mapper.TopoMapper;
import truespot.business.dto.mapper.UserMapper;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

import java.util.*;


@Service
public class TopoManagerImpl extends BusinessManagerImpl implements TopoManager {

    @Autowired
    DepartmentManagerImpl departmentManager;

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
    public TopoDTO getTopo(Long id) {

        Optional<Topo> topoOptional = getDaoFactory().getTopoRepository().findById(id);

        Topo topo = null;

        if(topoOptional.isPresent()){
            topo = new Topo(
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
        if(topoDTO.getRelease_Date() == null){ topoDTO.setRelease_Date(new Date());}
        if(topoDTO.getAvaible() == null) { topoDTO.setAvaible(true); }
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

        Topo topo = TopoMapper.dtoToObject(topoDTO);
        topo.setUser(user);


        return getDaoFactory().getTopoRepository().save(topo);
    }


    @Override
    public void updateTopo(Long id, Topo topo) {
        TopoDTO topoDTO = getTopo(id);
        TopoMapper.updateDTO(topoDTO, topo);
        topo.setId(id);
        getDaoFactory().getTopoRepository().save(topo);
    }

    @Override
    public void deleteTopo(Long id) {
        getDaoFactory().getTopoRepository().deleteById(id);
    }
}
