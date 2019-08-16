package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long> {
}
