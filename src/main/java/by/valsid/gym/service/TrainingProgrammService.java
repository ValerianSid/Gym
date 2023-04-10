package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.TrainingNotFound;
import by.valsid.gym.model.dto.TrainingProgrammDto;
import by.valsid.gym.model.entity.TrainingProgramm;
import by.valsid.gym.model.mapping.TrainingProgrammMapper;
import by.valsid.gym.repository.TrainingProgrammRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
