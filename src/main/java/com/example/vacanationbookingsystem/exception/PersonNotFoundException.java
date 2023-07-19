package com.example.vacanationbookingsystem.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String mess){
        super(mess);
    }
}
