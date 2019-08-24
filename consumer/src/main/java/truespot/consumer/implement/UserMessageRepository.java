package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import truespot.model.UserMessage;

import java.util.List;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    @Query("select m from UserMessage m, Topo t where  m.topo.id = t.id and t.id =:id")
    List<UserMessage> findAllUserMessageByTopoID(@Param("id") Long id);
}
