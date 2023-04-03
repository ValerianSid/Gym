package by.valsid.gym.web;

import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.service.BasicExerciseService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basic_exercise")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BasicExerciseController {

        BasicExerciseService basicExerciseService;

        @PutMapping("/createNewExercise")
        public ResponseEntity<String> createNewExercise(@RequestBody BasicExerciseDto basicExerciseDto){
            return ResponseEntity.ok(basicExerciseService.createNewExercise(basicExerciseDto));
        }

        @GetMapping("/showAllExercises")
        public ResponseEntity<List<BasicExerciseDto>> showAllExercises(){
            return ResponseEntity.ok(basicExerciseService.showAllExercises());
        }
}
