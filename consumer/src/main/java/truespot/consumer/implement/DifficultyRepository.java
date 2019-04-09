package truespot.consumer.implement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import truespot.model.Difficulty;

@Repository
public interface DifficultyRepository extends JpaRepository <Difficulty, Long> {
}
