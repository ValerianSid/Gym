package by.valsid.gym.service;

import by.valsid.gym.constants.StringConstants;
import by.valsid.gym.exceptions.ExerciseNotFound;
import by.valsid.gym.exceptions.TestException;
import by.valsid.gym.model.dto.BasicExerciseDto;
import by.valsid.gym.model.entity.BasicExercise;
import by.valsid.gym.model.mapping.BasicExerciseMapper;
import by.valsid.gym.repository.BasicExerciseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BasicExerciseService {

    BasicExerciseMapper basicExerciseMapper;

    BasicExerciseRepository basicExerciseRepository;
    public String createNewExercise(BasicExerciseDto basicExerciseDto){
        BasicExercise basicExercise = basicExerciseMapper.toEntity(basicExerciseDto);
        basicExerciseRepository.save(basicExercise);
        return StringConstants.EXERCISE_WAS_CREATED;
    }

    public List<BasicExerciseDto> showAllExercises(){
        List<BasicExerciseDto> basicExerciseDtoList = new ArrayList<>();
        List<BasicExercise> basicExerciseList = basicExerciseRepository.findAll();
        if (basicExerciseList.isEmpty()){
            throw new ExerciseNotFound();
        }
        for (BasicExercise basicExercise : basicExerciseList) {
                basicExerciseDtoList.add(basicExerciseMapper.toDto(basicExercise));
        }
        return basicExerciseDtoList;
    }

    public List<BasicExerciseDto> showByMuscleGroup(String muscleGroup){
        List<BasicExercise> basicExerciseList = basicExerciseRepository.findByMuscleGroup(muscleGroup);
        List<BasicExerciseDto> basicExerciseDtoList = new ArrayList<>();
        if (basicExerciseList.isEmpty()) {
            throw new ExerciseNotFound();
        }
        for (BasicExercise basicExercise : basicExerciseList) {
            basicExerciseDtoList.add(basicExerciseMapper.toDto(basicExercise));
        }
        return basicExerciseDtoList;
    }
}
