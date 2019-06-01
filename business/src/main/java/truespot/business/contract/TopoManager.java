package truespot.business.contract;

import truespot.business.dto.TopoDTO;
import truespot.model.Topo;
import java.util.List;

public interface TopoManager {

    List<Topo> findAllTopo();

    TopoDTO getTopo(Long id);

    Topo saveTopo(TopoDTO topoDTO);

    void updateTopo(Long id, Topo topo);

    void deleteTopo(Long id);
}
