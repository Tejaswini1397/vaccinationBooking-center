package com.example.vacanationbookingsystem.exception;

public class DoseAlreadyTakenException extends RuntimeException{
    public DoseAlreadyTakenException(String mess){
        super(mess);
    }
}
