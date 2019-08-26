package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truespot.model.Share;
import truespot.model.Topo;
import truespot.model.User;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long> {

    @Query("select  s from Share s, Topo t where s.topo.id = t.id and s.topo.id =:id")
    Share findShareByTopo(@Param("id")  Long id);

    @Query("select  s from Share s, Topo t where s.topo.id = t.id and s.topo.id =:id")
    Share findUserShare(@Param("id")  Long id);

}
