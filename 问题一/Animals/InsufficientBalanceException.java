package com.Animals;

public class InsufficientBalanceException extends RuntimeException{
    private String message;

    public InsufficientBalanceException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
