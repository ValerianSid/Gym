package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.ExerciseNotCreated;
import by.valsid.gym.exceptions.ExerciseNotFound;
import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.IndividualExerciseDto;
import by.valsid.gym.model.dto.IndividualTrainingProgrammDto;
import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import by.valsid.gym.model.mapping.BasicExerciseMapper;
import by.valsid.gym.model.mapping.IndividualExerciseMapper;
import by.valsid.gym.model.mapping.IndividualTrainingProgrammMapper;
import by.valsid.gym.repository.BasicExerciseRepository;
import by.valsid.gym.repository.IndividualExerciseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class IndividualExerciseService {

    IndividualExerciseRepository individualExerciseRepository;

    BasicExerciseRepository basicExerciseRepository;

    IndividualExerciseMapper individualExerciseMapper;

    public void addFromTrainingExercise(TrainingProgrammExercise trainingProgrammExercise, IndividualTrainingProgramm individualTrainingProgramm){
        individualExerciseRepository.save(IndividualExercise.builder()
                .description(trainingProgrammExercise.getDescription())
                .basicExercise(trainingProgrammExercise.getBasicExercise())
                .individualTrainingProgramm(individualTrainingProgramm)
                .build());
    }

    public String addToIndTrProg(IndividualTrainingProgramm individualTrainingProgramm, Long basicExId, String description){
        try{
            individualExerciseRepository.save(IndividualExercise.builder()
                    .description(description)
                    .individualTrainingProgramm(individualTrainingProgramm)
                    .basicExercise(basicExerciseRepository.findById(basicExId).get())
                    .build());
        }
        catch (Exception e){
            log.error(e.getMessage(), e); //для проверки какую ошибку поймал
            throw new ExerciseNotCreated();
        }
        return StringConstants.EXERCISE_WAS_CREATED;
    }

    public void completeTrainingExercise(IndividualExerciseDto individualExerciseDto){
        individualExerciseRepository.save(individualExerciseMapper.toEntity(individualExerciseDto));
    }

    public List<IndividualExerciseDto> showExByTrPrg(Long indTrProgId){
        List<IndividualExercise> individualExerciseList = individualExerciseRepository.findByTrProg(indTrProgId);
        List<IndividualExerciseDto> individualExerciseDtoList = new ArrayList<>();
        for(IndividualExercise individualExercise : individualExerciseList){
            individualExerciseDtoList.add(individualExerciseMapper.toDto(individualExercise));
        }
        if (individualExerciseDtoList.isEmpty()){
            throw new ExerciseNotFound();
        }
        return individualExerciseDtoList;
    }
}
