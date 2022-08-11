package com.sparta.ml.exceptions;

public class SorterLoaderException extends Exception {

    private final String message;
    public SorterLoaderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
