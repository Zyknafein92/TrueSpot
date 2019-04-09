package truespot.business.contract;

import truespot.model.Difficulty;
import java.util.Optional;

public interface DifficultyManager {

    Optional<Difficulty> getDifficulty(Long id);

    Difficulty saveDifficulty(Difficulty difficulty);

    void updateDifficulty(Long id, Difficulty difficulty);

    void deleteDifficulty(Long id);
}
