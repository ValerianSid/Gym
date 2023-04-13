package by.valsid.gym.web;

import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.IndividualExerciseDto;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.service.IndividualExerciseService;
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
@RequestMapping("/ind_exercise")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IndividualExerciseController {

    IndividualExerciseService individualExerciseService;

    @GetMapping("/showByTrProg")
    public ResponseEntity<List<IndividualExerciseDto>> showByTrProg(Long indTrProgId){
        return ResponseEntity.ok(individualExerciseService.showExByTrPrg(indTrProgId));
    }

}
