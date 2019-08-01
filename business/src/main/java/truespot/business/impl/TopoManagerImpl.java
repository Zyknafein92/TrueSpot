package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import truespot.business.contract.TopoManager;
import truespot.business.dto.TopoDTO;
import truespot.business.dto.mapper.TopoMapper;
import truespot.model.Department;
import truespot.model.Topo;

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
    public Topo saveTopo(TopoDTO topoDTO) {
        Topo topo = TopoMapper.dtoToObject(topoDTO);
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
