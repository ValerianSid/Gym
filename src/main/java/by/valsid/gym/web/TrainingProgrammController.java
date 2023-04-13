package by.valsid.gym.web;

import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.service.TrainingProgrammService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/training_prog")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainingProgrammController {

    TrainingProgrammService trainingProgrammService;
    @PostMapping("/createTrainingProg")
    public ResponseEntity<String> createNewTP(TrainingProgrammDto trainingProgrammDto){
        return ResponseEntity.ok(trainingProgrammService.addNewTraining(trainingProgrammDto));
    }

    @GetMapping("/showAllTrProg")
    public ResponseEntity<List<TrainingProgrammDto>> showAllProgs(){
        return ResponseEntity.ok(trainingProgrammService.showAllPrograms());
    }

    @PostMapping("/addExerciseToTrProg")
    public  ResponseEntity<String> addExerciseToTrProg(Long trProgId, Long basicExId, String description){
        return ResponseEntity.ok(trainingProgrammService.addExerciseToTraining(trProgId, basicExId, description));
    }
}
