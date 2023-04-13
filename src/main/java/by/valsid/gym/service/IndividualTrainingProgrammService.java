package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.TrainingNotAdded;
import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.model.mapping.BasicExerciseMapper;
import by.valsid.gym.model.mapping.IndividualTrainingProgrammMapper;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.IndividualTrainingProgrammRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class IndividualTrainingProgrammService {

    IndividualTrainingProgrammMapper individualTrainingProgrammMapper;

    TrainingProgrammMapper trainingProgrammMapper;

    IndividualTrainingProgrammRepository individualTrainingProgrammRepository;

    IndividualExerciseService individualExerciseService;


    public String createMyTrProg(IndividualTrainingProgrammDto individualTrainingProgrammDto){
        try{
            individualTrainingProgrammRepository.save(individualTrainingProgrammMapper.toEntity(individualTrainingProgrammDto));
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            throw new TrainingNotAdded();
        }
        return StringConstants.TRAINING_NOT_CREATED;
    }

    public String addExerciseToTrProg(Long indTrProgId, Long basicExId, String description){
            individualExerciseService.addToIndTrProg(individualTrainingProgrammRepository.findById(indTrProgId).get(),
                    basicExId, description);
        return StringConstants.EXERCISE_WAS_CREATED;
    }

    public String addTrainingProgrammToMy(TrainingProgrammDto trainingProgrammDto){
        List<IndividualExercise> excercises = trainingProgrammMapper.toIndividualExcersize(trainingProgrammDto.getTrainingProgrammExerciseList());
        try {
            individualTrainingProgrammRepository.save(IndividualTrainingProgramm.builder()
                    .name(trainingProgrammDto.getName())
                    .name(trainingProgrammDto.getDescription())
                    .description(trainingProgrammDto.getDescription())
                    .individualExerciseList(excercises)
                    .build());
        }
        catch (Exception e){
            log.error(e.getMessage(), e); //для проверки какая конкретно ошибка
            throw new TrainingNotAdded();
        }
        return StringConstants.TRAINING_WAS_ADDED;
    }
}
