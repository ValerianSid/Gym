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

    BasicExerciseMapper basicExerciseMapper;


    //добавить пользователя
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

    public String createMyOwnTraining(IndividualTrainingProgrammDto individualTrainingProgrammDto, Map<BasicExerciseDto, String> exerciseMap){
        List<IndividualExercise> individualExerciseList  = new ArrayList<>();
        exerciseMap.forEach((basicExerciseDto, description) ->{
            individualExerciseList.add(IndividualExercise.builder()
                    .description(description)
                    .basicExercise(basicExerciseMapper.toEntity(basicExerciseDto))
                    .build());
        });
        try{
            IndividualTrainingProgramm individualTrainingProgramm = individualTrainingProgrammMapper.toEntity(individualTrainingProgrammDto);
            individualTrainingProgramm.setIndividualExerciseList(individualExerciseList);
            individualTrainingProgrammRepository.save(individualTrainingProgramm);
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            throw new TrainingNotAdded();
        }
        return StringConstants.TRAINING_WAS_ADDED;
    }
}
