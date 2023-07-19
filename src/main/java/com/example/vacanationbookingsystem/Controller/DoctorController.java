package com.example.vacanationbookingsystem.Controller;

import com.example.vacanationbookingsystem.Repository.DoctorRepository;
import com.example.vacanationbookingsystem.Service.DoctorService;
import com.example.vacanationbookingsystem.dto.Requestdto.DoctorRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.DoctorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add_doctor")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto ){
        try {
            DoctorResponseDto doctorResponseDto =doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity<>(doctorResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public List<String> getByAgeGreaterThan(@RequestParam("age") int age){
        List<String>doctors=doctorService.getAgeGreaterThan(age);
        return doctors;
    }
}
