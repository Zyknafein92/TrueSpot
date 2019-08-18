package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository <Topo, Long> {

    List<Topo> findAllByUser_Pseudo(String pseudo);
    List<Topo> findAllByDepartment_Id(Long id);
}
