package truespot.business.impl;

import org.springframework.stereotype.Service;
import truespot.business.contract.DifficultyManager;
import truespot.model.Difficulty;

import java.util.Optional;

@Service
public class DifficultyManagerImpl extends BusinessManagerImpl implements DifficultyManager {
    @Override
    public Optional<Difficulty> getDifficulty(Long id) {
        return getDaoFactory().getDifficultyRepository().findById(id);
    }

    @Override
    public Difficulty saveDifficulty(Difficulty difficulty) {
        return getDaoFactory().getDifficultyRepository().save(difficulty);
    }

    @Override
    public void updateDifficulty(Long id, Difficulty difficulty) {
     //todo
    }

    @Override
    public void deleteDifficulty(Long id) {
        getDaoFactory().getDifficultyRepository().deleteById(id);
    }
}
