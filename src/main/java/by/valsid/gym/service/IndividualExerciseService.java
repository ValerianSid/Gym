package by.valsid.gym.service;

import by.valsid.gym.model.entity.IndividualExercise;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import by.valsid.gym.repository.IndividualExerciseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IndividualExerciseService {

    IndividualExerciseRepository individualExerciseRepository;

    public void addFromTrainingExercise(TrainingProgrammExercise trainingProgrammExercise, IndividualTrainingProgramm individualTrainingProgramm){
        individualExerciseRepository.save(IndividualExercise.builder()
                .description(trainingProgrammExercise.getDescription())
                .basicExercise(trainingProgrammExercise.getBasicExercise())
                .individualTrainingProgramm(individualTrainingProgramm)
                .build());
    }
}
