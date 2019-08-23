package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truespot.model.Department;
import truespot.model.Topo;
import truespot.model.User;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository <Topo, Long> {

    @Query("select t from Topo t, User u where  t.user.id = u.id and u.pseudo =:pseudo")
    List<Topo> findAllByUser_Pseudo(@Param("pseudo") String pseudo);

    @Query("select t from Topo t, Department d where  t.department.id = d.id and d.id =:id")
    List<Topo> findAllByDepartment_Id(@Param("id")  Long id);

    @Query("select t from Topo t, Share s where  t.user.id = s.userReceiver.id and s.userReceiver.id =:id")
    List<Topo> findAllTopos(@Param("id")  Long id);
}
