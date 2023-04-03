package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.entity.BasicExercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasicExerciseMapper {

    BasicExercise toEntity(BasicExerciseDto basicExerciseDto);

    BasicExerciseDto toDto(BasicExercise basicExercise);
}
