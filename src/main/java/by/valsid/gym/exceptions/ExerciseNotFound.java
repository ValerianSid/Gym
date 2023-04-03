package by.valsid.gym.exceptions;

import by.valsid.gym.constants.StringConstants;

public class ExerciseNotFound extends RuntimeException{

    public ExerciseNotFound(){
        super(StringConstants.EXERCISE_LIST_EMPTY);
    }
}
