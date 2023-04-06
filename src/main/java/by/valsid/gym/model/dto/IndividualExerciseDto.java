package by.valsid.gym.model.dto;

import by.valsid.gym.model.entity.BasicExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IndividualExerciseDto {

    Long id;

    String description;

    Short repeats;

    Short executionTime;

    Float weigth;

    IndividualTrainingProgramm individualTrainingProgramm;

    BasicExercise basicExercise;
}
