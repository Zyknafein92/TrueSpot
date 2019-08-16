package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.UserMessage;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {
}
