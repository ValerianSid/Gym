package by.valsid.gym.exceptions;

import by.valsid.gym.constants.StringConstants;

public class ExerciseNotCreated extends RuntimeException{
    public ExerciseNotCreated() {
        super(StringConstants.EXERCISE_NOT_CREATED);
    }
}
