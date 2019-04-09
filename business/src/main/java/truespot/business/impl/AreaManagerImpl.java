package truespot.business.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import truespot.business.contract.AreaManager;
import truespot.model.Area;
import java.util.List;
import java.util.Optional;

@Service
public class AreaManagerImpl extends BusinessManagerImpl implements AreaManager {


    @Override
    public List<Area> findAllArea() {
        return getDaoFactory().getAreaRepository().findAll();
    }

    @Override
    public Optional<Area> getArea(@PathVariable Long id) {
        return getDaoFactory().getAreaRepository().findById(id);
    }


    @Override
    public Area saveArea(Area area) {
        return getDaoFactory().getAreaRepository().save(area);
    }

    @Override
    public void updateArea(Long id, Area area) {
    //TODO
    }

    @Override
    public void deleteArea(Long id) { getDaoFactory().getAreaRepository().deleteById(id);}
}
