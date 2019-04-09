package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Topo;

@Repository
public interface TopoRepository extends JpaRepository <Topo, Long> {

}
