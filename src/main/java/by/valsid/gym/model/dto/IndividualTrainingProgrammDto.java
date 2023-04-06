package by.valsid.gym.model.dto;

import by.valsid.gym.model.entity.CompleteTraining;
import by.valsid.gym.model.entity.IndividualExercise;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IndividualTrainingProgrammDto {

    Long id;

    String name;

    String description;

    List<IndividualExercise> individualExerciseList;

    List<CompleteTraining> completeTrainingList;
}
