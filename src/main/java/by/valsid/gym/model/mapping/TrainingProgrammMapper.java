package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.TrainingProgramm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingProgrammMapper {

    TrainingProgramm toEntity(TrainingProgrammDto trainingProgrammDto);

    TrainingProgrammDto toDto(TrainingProgramm trainingProgramm);
}
