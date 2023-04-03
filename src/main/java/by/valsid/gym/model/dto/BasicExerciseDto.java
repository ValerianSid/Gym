package by.valsid.gym.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasicExerciseDto {

    Long id;

    String name;

    String instruction;

    String muscleGroup;
}
