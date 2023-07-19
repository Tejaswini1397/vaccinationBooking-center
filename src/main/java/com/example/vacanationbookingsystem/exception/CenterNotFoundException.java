package com.example.vacanationbookingsystem.exception;

public class CenterNotFoundException extends RuntimeException {
    public CenterNotFoundException(String mess){
        super(mess);
    }
}
