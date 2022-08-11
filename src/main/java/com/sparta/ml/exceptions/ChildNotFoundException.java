package com.sparta.ml.exceptions;

public class ChildNotFoundException extends Exception{
    public ChildNotFoundException() {
        super("No child in this direction.");
    }

    public ChildNotFoundException(String message) {
        super(message);
    }
}
