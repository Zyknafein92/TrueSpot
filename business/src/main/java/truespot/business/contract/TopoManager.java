package truespot.business.contract;

import truespot.model.Topo;
import java.util.List;
import java.util.Optional;

public interface TopoManager {

    List<Topo> findAllTopo();

    Optional<Topo> getTopo(Long id);

    Topo saveTopo(Topo topo);

    void updateTopo(Long id, Topo topo);

    void deleteTopo(Long id);
}
