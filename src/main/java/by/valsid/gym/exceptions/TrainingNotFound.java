package by.valsid.gym.exceptions;

import by.valsid.gym.constants.StringConstants;

public class TrainingNotFound extends RuntimeException{
    public TrainingNotFound() {
        super(StringConstants.TRAINING_NOT_FOUND);
    }
}
