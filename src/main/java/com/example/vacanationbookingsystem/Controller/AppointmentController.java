package com.example.vacanationbookingsystem.Controller;

import com.example.vacanationbookingsystem.Model.Appointment;
import com.example.vacanationbookingsystem.Service.AppointmentService;
import com.example.vacanationbookingsystem.dto.Requestdto.BookAppointmentRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.BookAppointmentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService service;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody BookAppointmentRequestDto bookAppointmentRequestDto){

        try{
            BookAppointmentResponseDto bookAppointmentResponseDto = service.bookAppointment(bookAppointmentRequestDto);
            return new ResponseEntity(bookAppointmentResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
