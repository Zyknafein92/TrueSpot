package truespot.consumer.implement;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truespot.model.ClimbingRoad;

import java.util.List;

@Repository
public interface ClimbingRoadRepository extends JpaRepository <ClimbingRoad, Long> {

    @Query("select distinct cb from ClimbingRoad cb, Area ar where  cb.area.id = ar.id and ar.id = :id")
    List<ClimbingRoad>findAllByArea(@Param("id") Long id);
}
