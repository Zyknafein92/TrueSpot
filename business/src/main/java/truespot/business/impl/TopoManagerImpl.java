package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.*;
import truespot.business.dto.TopoDTO;
import truespot.business.dto.TopoDTOContext;
import truespot.business.dto.UserDTO;
import truespot.business.dto.mapper.DepartmentMapper;
import truespot.business.dto.mapper.TopoMapper;
import truespot.business.dto.mapper.UserMapper;
import truespot.model.*;

import java.util.*;


@Service
public class TopoManagerImpl extends BusinessManagerImpl implements TopoManager {

    @Autowired
    DepartmentManager departmentManager;
    @Autowired
    AreaManager areaManager;
    @Autowired
    UserMessageManager userMessageManager;
    @Autowired
    ShareManager shareManager;

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
        return getDaoFactory().getTopoRepository().findAllShareTopoByUser(id);
    }

    @Override
    public List<Topo> searchCriteres(Long idDepartment, String avaible, String typee) {
      return getDaoFactory().getTopoRepository().searchCriteres(idDepartment,"%" + avaible +"%" ,"%" +typee+"%");
      //  return getDaoFactory().getTopoRepository().searchCriteres(idDepartment, avaible  ,typee);
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
                    topoOptional.get().getAvaible(),
                    topoOptional.get().getIsAmical()
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
        topoDTO.setIsAmical(topoDTOContext.getIsAmical());
        topoDTO.setAvaible("WGOOOD");

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
        List<UserMessage> messages = getDaoFactory().getUserMessageRepository().findAllUserMessageByTopoID(id);
        Share share;


        if(areas.size() > 0){
            for (Area area: areas) {
                Area areaDelete = getDaoFactory().getAreaRepository().getOne(area.getId());
                areaManager.deleteArea(areaDelete.getId());
            }
        }

        if(messages.size() > 0){
            for(UserMessage userMessage : messages) {
                UserMessage userMessageD =  getDaoFactory().getUserMessageRepository().getOne(userMessage.getId());
                userMessageManager.deleteUserMessage(userMessageD.getId());
            }
        }


            share = getDaoFactory().getShareRepository().findShareByTopo(id);
           if(share != null){shareManager.deleteShare(share.getId());}

        getDaoFactory().getTopoRepository().delete(getDaoFactory().getTopoRepository().getOne(id));
    }
}
