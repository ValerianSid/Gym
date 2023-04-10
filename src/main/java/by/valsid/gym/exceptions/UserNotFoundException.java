package by.valsid.gym.exceptions;

import by.valsid.gym.constants.StringConstants;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super(StringConstants.USER_NOT_FOUND);
    }
}
