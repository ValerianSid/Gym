package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.TrainingProgrammRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrainingProgrammService {

    TrainingProgrammMapper trainingProgrammMapper;

    TrainingProgrammRepository trainingProgrammRepository;

    public String addNewTraining(TrainingProgrammDto trainingProgrammDto){
        trainingProgrammRepository.save(trainingProgrammMapper.toEntity(trainingProgrammDto));
        return StringConstants.TRAINING_WAS_CREATED;
    }
}
