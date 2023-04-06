package by.valsid.gym.model.dto;

import by.valsid.gym.model.entity.TrainingProgramm;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainingProgrammDto {

    Long id;

    String name;

    String description;

    List<TrainingProgramm> trainingProgrammList;
}
