package truespot.business.contract;


import truespot.business.dto.TopoDTO;
import truespot.business.dto.TopoDTOContext;
import truespot.model.Topo;
import java.util.List;

public interface TopoManager {

    List<Topo> findAllTopo();

    TopoDTO getTopo(Long id);

    Topo saveTopo(TopoDTOContext topoDTOContext);

    void updateTopo(Long id, Topo topo);

    void deleteTopo(Long id);

    //Boolean process(TestClasseNeed testClasseNeed );
}
