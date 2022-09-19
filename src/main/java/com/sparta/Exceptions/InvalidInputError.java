package com.sparta.Exceptions;

import java.util.InputMismatchException;

public class InvalidInputError extends Exception  {


        public InvalidInputError() {
            super("Incorrect entry");
        }
        public InvalidInputError(String message) {
            super(message);
        }

 }
