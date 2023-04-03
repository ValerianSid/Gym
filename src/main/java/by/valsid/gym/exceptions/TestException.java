package by.valsid.gym.exceptions;

public class TestException extends RuntimeException{

    public TestException(){
        super(String.format("Возникли проблемы"));
    }
}
