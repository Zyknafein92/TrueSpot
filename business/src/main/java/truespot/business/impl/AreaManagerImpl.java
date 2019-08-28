package truespot.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import truespot.business.contract.AreaManager;
import truespot.business.contract.ClimbingRoadManager;
import truespot.business.dto.AreaDTO;
import truespot.business.dto.mapper.AreaMapper;
import truespot.model.Area;
import truespot.model.ClimbingRoad;
import truespot.model.Topo;

import java.util.List;

@Service
public class AreaManagerImpl extends BusinessManagerImpl implements AreaManager {

    @Autowired
    ClimbingRoadManager climbingRoadManager;

    @Override
    public List<Area> findAllArea() {
        return getDaoFactory().getAreaRepository().findAll();
    }

    @Override
    public List<Area> findAllByIdTopo(Long idTopo) {
        return getDaoFactory().getAreaRepository().findAllByTopo(idTopo);
    }

    @Override
    @Transactional
    public List<Area> deleteAreaByTopo(Long id) {
        return getDaoFactory().getAreaRepository().deleteAreaByTopo(id);
    }


    @Override
    public Area getArea(Long id) {
        return getDaoFactory().getAreaRepository().getOne(id);
    }


    @Override
    public Area saveArea(AreaDTO areaDTO) {
       Topo topo = getDaoFactory().getTopoRepository().getOne(new Long(areaDTO.getIdTopo()));

        Area area = AreaMapper.DTOToObject(areaDTO);
        area.setTopo(topo);
        return getDaoFactory().getAreaRepository().save(area);
    }

    @Override
    public void updateArea(AreaDTO areaDTO) {
        Topo topo = getDaoFactory().getTopoRepository().getOne(Long.valueOf(areaDTO.getIdTopo()));

        Area area = AreaMapper.DTOToObject(areaDTO);
        area.setTopo(topo);
        area.setId(areaDTO.getId());
        getDaoFactory().getAreaRepository().save(area);
    }

    @Override
    public void deleteArea(Long idArea) {
        List<ClimbingRoad> roads = getDaoFactory().getClimbingRoadRepository().findAllByArea(idArea);
        if(roads.size() > 0){
            for (ClimbingRoad climbingRoad: roads) {
                getDaoFactory().getClimbingRoadRepository().delete(climbingRoad);
            }
        }
        getDaoFactory().getAreaRepository().delete(getDaoFactory().getAreaRepository().getOne(idArea));}
}
