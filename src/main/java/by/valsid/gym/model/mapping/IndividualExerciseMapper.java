package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.IndividualExerciseDto;
import by.valsid.gym.model.entity.IndividualExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndividualExerciseMapper {

    IndividualExercise toEntity(IndividualExerciseDto individualExerciseDto);

    IndividualExerciseDto toDto(IndividualExercise individualExercise);
}
