package by.valsid.gym.service;

import by.valsid.gym.exceptions.ExerciseNotCreated;
import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.TrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import by.valsid.gym.model.mapping.BasicExerciseMapper;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.BasicExerciseRepository;
import by.valsid.gym.repository.TrainingProgrammExerciseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TrainingProgrammExerciseService {

    TrainingProgrammExerciseRepository trainingProgrammExerciseRepository;

    BasicExerciseRepository basicExerciseRepository;

    public void addToTrProg(TrainingProgramm trainingProgramm, Long basicExId, String description){
        try {
            trainingProgrammExerciseRepository.save(TrainingProgrammExercise.builder()
                    .description(description)
                    .trainingProgramm(trainingProgramm)
                    .basicExercise(basicExerciseRepository.findById(basicExId).get())
                    .build());
        }
        catch (Exception e){
            log.error(e.getMessage(), e); //для проверки какую ошибку поймал
            throw new ExerciseNotCreated();
        }
        }
}
