package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndividualTrainingProgrammMapper {

    IndividualTrainingProgramm toEntity(IndividualTrainingProgrammDto individualTrainingProgrammDto);

    IndividualTrainingProgrammDto toDto(IndividualTrainingProgramm individualTrainingProgramm);

}
