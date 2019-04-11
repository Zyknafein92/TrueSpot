package truespot.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import truespot.business.contract.DifficultyManager;
import truespot.model.Difficulty;
import truespot.webapp.dto.DifficultyDTO;

import java.util.List;
import java.util.Optional;

@RestController
public class DifficultyController {

    @Autowired
    private DifficultyManager difficultyManager;

    @GetMapping(value="/difficulty")
    public List<Difficulty> getAllDifficulties(){
        return difficultyManager.findAllDifficulties();
    }

    @GetMapping(value="/difficulty/{id}")
    public DifficultyDTO getDifficulty(@PathVariable Long id) {
        Optional<Difficulty> Difficulty = difficultyManager.getDifficulty(id);

        if(Difficulty.isPresent()){
            Difficulty difficultyReal = Difficulty.get();
            DifficultyDTO difficultyDTO = new DifficultyDTO();

            difficultyDTO.setNumber(difficultyReal.getNumber());
            difficultyDTO.setLetter(difficultyReal.getLetter());
            difficultyDTO.setSymbol(difficultyReal.getSymbol());

            difficultyReal = difficultyManager.saveDifficulty(difficultyReal);
            difficultyDTO.setId(difficultyReal.getId());
            return difficultyDTO;

        }throw new RuntimeException("Difficulty not found");
    }


    @PostMapping(value="/difficulty")
    public DifficultyDTO createDifficulty(@RequestBody DifficultyDTO difficultyDTO){

        Difficulty difficulty = new Difficulty();

        difficulty.setNumber(difficultyDTO.getNumber());
        difficulty.setLetter(difficultyDTO.getLetter());
        difficulty.setSymbol(difficultyDTO.getSymbol());

        difficulty = difficultyManager.saveDifficulty(difficulty);
        difficultyDTO.setId(difficulty.getId());
        return difficultyDTO;
    }


    @PutMapping(value = "/difficulty/{id}")
    public void updateDifficulty(@PathVariable Long id , @RequestBody Difficulty difficulty) {
        difficultyManager.updateDifficulty(id,difficulty);
    }


    @DeleteMapping(value= "/difficulty/{id}")
    public void deleteDifficulty(@PathVariable Long id){
        difficultyManager.deleteDifficulty(id);
    }
}
