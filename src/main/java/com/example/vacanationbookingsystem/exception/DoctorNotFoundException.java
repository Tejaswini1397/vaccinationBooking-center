package com.example.vacanationbookingsystem.exception;

public class DoctorNotFoundException extends RuntimeException{
    public  DoctorNotFoundException(String mess){
        super(mess);
    }
}
