package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.model.mapping.IndividualTrainingProgrammMapper;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.IndividualTrainingProgrammRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IndividualTrainingProgrammService {

    IndividualTrainingProgrammMapper individualTrainingProgrammMapper;

    TrainingProgrammMapper trainingProgrammMapper;

    IndividualTrainingProgrammRepository individualTrainingProgrammRepository;

    IndividualExerciseService individualExerciseService;

    public String createMyTraining(IndividualTrainingProgrammDto individualTrainingProgrammDto){
        individualTrainingProgrammRepository.save(individualTrainingProgrammMapper.toEntity(individualTrainingProgrammDto));
        return StringConstants.TRAINING_WAS_CREATED;
    }

    //добавить пользователя
    public String addTrainingProgrammToMy(TrainingProgrammDto trainingProgrammDto){
        List<IndividualExercise> excercises = trainingProgrammMapper.toIndividualExcersize(trainingProgrammDto.getTrainingProgrammExerciseList());
        IndividualTrainingProgramm individualTrainingProgramm = individualTrainingProgrammRepository.save(IndividualTrainingProgramm.builder()
                .name(trainingProgrammDto.getName())
                .name(trainingProgrammDto.getDescription())
                .description(trainingProgrammDto.getDescription())
                .individualExerciseList(excercises)
                .build());
        return StringConstants.TRAINING_WAS_ADDED;
    }
}
