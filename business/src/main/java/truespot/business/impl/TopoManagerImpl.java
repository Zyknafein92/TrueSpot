package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.TopoManager;
import truespot.business.dto.DepartmentDTO;
import truespot.business.dto.TopoDTO;
import truespot.business.dto.TopoDTOContext;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.DepartmentMapper;
import truespot.business.dto.mapper.TopoMapper;
import truespot.business.dto.mapper.UserMapper;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

// TODO: 10/05/2019 refactor selon area 
@Service
public class TopoManagerImpl extends BusinessManagerImpl implements TopoManager {

    @Autowired
    DepartmentManagerImpl departmentManager;

    @Override
    public List<Topo> findAllTopo() {
        return getDaoFactory().getTopoRepository().findAll();
    }

    @Override
    public TopoDTO getTopo(Long id) {

        Optional<Topo> topoOptional = getDaoFactory().getTopoRepository().findById(id);

        Topo topo = null;

        if(topoOptional.isPresent()){
            topo = new Topo(
                    topoOptional.get().getName(),
                    topoOptional.get().getUser(),
                    topoOptional.get().getDepartment()
            );
        }

        return topo != null ? TopoMapper.objectToDTO(topo) : null;
    }

    @Override
    public Topo saveTopo(TopoDTOContext topoDTOContext) {


        User user = getDaoFactory().getUserRepository().findByPseudo(topoDTOContext.getUserPseudo());
        Department department = getDaoFactory().getDepartmentRepository().getOne(topoDTOContext.getIdDepartment());

//        Topo topo = new Topo();
//        topo.setName(topoDTOContext.getName());
//        topo.setUser(user);
//        topo.setDepartment(department);

        TopoDTO topoDTO = new TopoDTO();

        topoDTO.setName(topoDTOContext.getName());
        UserDTO userDTO = UserMapper.objectToDTO(user);
        topoDTO.setUser(userDTO);
        topoDTO.getUser().setRoles(new HashSet<>());
        topoDTO.setDepartment(DepartmentMapper.objectToDTO(department));
        Topo topo = TopoMapper.dtoToObject(topoDTO);
        topo.setUser(user);


        return getDaoFactory().getTopoRepository().save(topo);
    }

//    @Override
//    public Boolean process(TestClasseNeed testClasseNeed) {
//
//        //call service creation topo => il te retourne un topo
//
//        // call service creation Sport => il te retourne un spot
//
//    }

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
