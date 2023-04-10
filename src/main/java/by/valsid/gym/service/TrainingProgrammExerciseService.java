package by.valsid.gym.service;

import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.TrainingProgrammExercise;
import by.valsid.gym.model.mapping.BasicExerciseMapper;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.TrainingProgrammExerciseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainingProgrammExerciseService {

    TrainingProgrammExerciseRepository trainingProgrammExerciseRepository;

    TrainingProgrammMapper trainingProgrammMapper;

    BasicExerciseMapper basicExerciseMapper;


}
