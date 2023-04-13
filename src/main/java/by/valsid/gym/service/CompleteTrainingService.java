package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.TrainingNotCompleted;
import by.valsid.gym.model.dto.IndividualExerciseDto;
import by.valsid.gym.model.entity.CompleteTraining;
import by.valsid.gym.model.entity.IndividualTrainingProgramm;
import by.valsid.gym.repository.CompleteTrainingRepository;
import by.valsid.gym.repository.IndividualTrainingProgrammRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CompleteTrainingService {

    IndividualExerciseService individualExerciseService;
    CompleteTrainingRepository completeTrainingRepository;

    //Добавить дату
    IndividualTrainingProgrammRepository individualTrainingProgrammRepository;
    public String completeTraining(Long indTrProgId, List<IndividualExerciseDto> individualExerciseDtoList){
        LocalDate localDate;
        try{
            for(IndividualExerciseDto individualExerciseDto : individualExerciseDtoList){
                individualExerciseService.completeTrainingExercise(individualExerciseDto);
            }
            completeTrainingRepository.save(CompleteTraining.builder()
                    .individualTrainingProgramm(individualTrainingProgrammRepository.findById(indTrProgId).orElseThrow())
                    .build());
        }
        catch (Exception e){
            log.error(e.getMessage(), e);
            throw new TrainingNotCompleted();
        }
        return StringConstants.TRAINING_COMPLETED;

    }
}
