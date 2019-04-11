package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.TopoManager;
import truespot.model.Topo;

import java.util.List;
import java.util.Optional;

@Service
public class TopoManagerImpl extends BusinessManagerImpl implements TopoManager {


    @Override
    public List<Topo> findAllTopo() {
        return getDaoFactory().getTopoRepository().findAll();
    }

    @Override
    public Optional<Topo> getTopo(Long id) {
        return getDaoFactory().getTopoRepository().findById(id);
    }

    @Override
    public Topo saveTopo(Topo topo) {
        return getDaoFactory().getTopoRepository().save(topo);
    }

    @Override
    public void updateTopo(Long id, Topo topo) {
        topo.setId(id);
        getDaoFactory().getTopoRepository().save(topo);
    }

    @Override
    public void deleteTopo(Long id) {
        getDaoFactory().getTopoRepository().deleteById(id);
    }
}
