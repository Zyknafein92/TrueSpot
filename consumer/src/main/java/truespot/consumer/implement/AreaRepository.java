package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truespot.model.Area;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository <Area, Long> {

    @Query("select ar from Area ar, Topo to where   ar.topo.id = to.id and ar.topo.id = :id")
    List<Area> findAllByTopo(@Param("id") long id);
}
