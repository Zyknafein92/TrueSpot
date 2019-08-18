package truespot.business.contract;


import truespot.business.dto.TopoDTO;
import truespot.business.dto.TopoDTOContext;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

import java.util.List;

public interface TopoManager {

    List<Topo> findAllTopo();

    List<Topo> findAllByUser_Pseudo(String pseudo);

    List<Topo> findAllByDepartment_Id(Long id);

    TopoDTO getTopo(Long id);

    Topo saveTopo(TopoDTOContext topoDTOContext);

    void updateTopo(Long id, Topo topo);

    void deleteTopo(Long id);
}
