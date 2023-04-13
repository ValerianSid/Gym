package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.ExerciseNotCreated;
import by.valsid.gym.exceptions.TrainingNotFound;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.TrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.TrainingProgrammRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TrainingProgrammService {

    TrainingProgrammMapper trainingProgrammMapper;

    TrainingProgrammRepository trainingProgrammRepository;

    TrainingProgrammExerciseService trainingProgrammExerciseService;

    public String addNewTraining(TrainingProgrammDto trainingProgrammDto){
        trainingProgrammRepository.save(trainingProgrammMapper.toEntity(trainingProgrammDto));
        return StringConstants.TRAINING_WAS_CREATED;
    }

    public String addExerciseToTraining(Long trProgId, Long basicExId, String description){
        try{
            trainingProgrammExerciseService.addToTrProg(trainingProgrammRepository.findById(trProgId).get(),
                                                        basicExId, description);
        }
        catch (Exception e){
            log.error(e.getMessage(), e); //для проверки какую ошибку поймал
            throw new ExerciseNotCreated();
        }
        return StringConstants.EXERCISE_NOT_CREATED;
    }

    public List<TrainingProgrammDto> showAllPrograms(){
        List<TrainingProgramm> trainingProgrammList = trainingProgrammRepository.findAll();
        List<TrainingProgrammDto> trainingProgrammDtoList = new ArrayList<>();
        if (trainingProgrammList.isEmpty()){
            throw new TrainingNotFound();
        }
        for (TrainingProgramm trainingProgramm : trainingProgrammList){
            trainingProgrammDtoList.add(trainingProgrammMapper.toDto(trainingProgramm));
        }
        return trainingProgrammDtoList;
    }
}
