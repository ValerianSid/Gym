package by.valsid.gym.service;

import by.valsid.gym.model.entity.CompleteTraining;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.repository.CompleteTrainingRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CompleteTrainingService {

    CompleteTrainingRepository completeTrainingRepository;
    public void completeTraining(IndividualTrainingProgramm individualTrainingProgramm){
        LocalDate localDate = new LocalDate.now();
        completeTrainingRepository.save(CompleteTraining.builder()
                .executionDate(localDate)
                .individualTrainingProgramm(individualTrainingProgramm)
                .build());
    }
}
