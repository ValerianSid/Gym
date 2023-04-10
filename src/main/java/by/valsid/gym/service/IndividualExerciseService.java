package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.ExerciseNotCreated;
import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import by.valsid.gym.model.mapping.BasicExerciseMapper;
import by.valsid.gym.model.mapping.IndividualTrainingProgrammMapper;
import by.valsid.gym.repository.IndividualExerciseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class IndividualExerciseService {

    IndividualExerciseRepository individualExerciseRepository;

    IndividualTrainingProgrammMapper individualTrainingProgrammMapper;

    BasicExerciseMapper basicExerciseMapper;

    public void addFromTrainingExercise(TrainingProgrammExercise trainingProgrammExercise, IndividualTrainingProgramm individualTrainingProgramm){
        individualExerciseRepository.save(IndividualExercise.builder()
                .description(trainingProgrammExercise.getDescription())
                .basicExercise(trainingProgrammExercise.getBasicExercise())
                .individualTrainingProgramm(individualTrainingProgramm)
                .build());
    }

    public String addToIndTrProg(IndividualTrainingProgrammDto individualTrainingProgrammDto, BasicExerciseDto basicExerciseDto, String description){
        try{
            individualExerciseRepository.save(IndividualExercise.builder()
                    .description(description)
                    .individualTrainingProgramm(individualTrainingProgrammMapper.toEntity(individualTrainingProgrammDto))
                    .basicExercise(basicExerciseMapper.toEntity(basicExerciseDto))
                    .build());
        }
        catch (Exception e){
            log.error(e.getMessage(), e); //для проверки какую ошибку поймал
            throw new ExerciseNotCreated();
        }
        return StringConstants.EXERCISE_WAS_CREATED;
    }


}
