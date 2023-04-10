package by.valsid.gym.exceptions;

import by.valsid.gym.constants.StringConstants;

public class TrainingNotAdded extends RuntimeException{
    public TrainingNotAdded() {
        super(StringConstants.TRAINING_NOT_ADDED);
    }
}
