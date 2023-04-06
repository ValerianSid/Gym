package by.valsid.gym.model.mapping;

import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainingProgrammMapper {

    TrainingProgramm toEntity(TrainingProgrammDto trainingProgrammDto);

    TrainingProgrammDto toDto(TrainingProgramm trainingProgramm);

    List<IndividualExercise> toIndividualExcersize(List<TrainingProgrammExercise> tpExcersizes);
}
