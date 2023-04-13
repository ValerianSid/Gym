package by.valsid.gym.web;

import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.service.IndividualTrainingProgrammService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ind_training_prog")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IndividualTrainingProgrammController {

    IndividualTrainingProgrammService individualTrainingProgrammService;

    @PostMapping("/addIndTraining")
    public ResponseEntity<String> addIndTraining(TrainingProgrammDto trainingProgrammDto){
        return ResponseEntity.ok(individualTrainingProgrammService.addTrainingProgrammToMy(trainingProgrammDto));
    }

    @PostMapping("/addExToTrProg")
    public ResponseEntity<String> addExToTrProg(Long indTrProgId, Long basicExId, String description){
        return ResponseEntity.ok(individualTrainingProgrammService.addExerciseToTrProg(indTrProgId, basicExId, description));
    }

    @PostMapping("/createMyTrainnig")
    public ResponseEntity<String> createMyTraining(IndividualTrainingProgrammDto individualTrainingProgrammDto){
        return ResponseEntity.ok(individualTrainingProgrammService.createMyTrProg(individualTrainingProgrammDto));
    }
}
