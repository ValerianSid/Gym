package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.IndividualExerciseDto;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IndividualTrainingProgrammMapper {

    IndividualTrainingProgramm toEntity(IndividualTrainingProgrammDto individualTrainingProgrammDto);

    IndividualTrainingProgrammDto toDto(IndividualTrainingProgramm individualTrainingProgramm);

    List<IndividualExerciseDto> toListDto(List<IndividualExercise> individualExerciseList);

}
