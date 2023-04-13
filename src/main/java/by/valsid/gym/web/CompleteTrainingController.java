package by.valsid.gym.web;

import by.valsid.gym.model.dto.IndividualExerciseDto;
import by.valsid.gym.service.CompleteTrainingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/complete_training")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CompleteTrainingController {

    CompleteTrainingService completeTrainingService;
    @PostMapping("/complete")
    public ResponseEntity<String> completeTraining(Long indTrProgId, List<IndividualExerciseDto> individualExerciseDtoList){
        return ResponseEntity.ok(completeTrainingService.completeTraining(indTrProgId, individualExerciseDtoList));
    }
}
