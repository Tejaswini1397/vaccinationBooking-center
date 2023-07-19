package com.example.vacanationbookingsystem.Controller;

import com.example.vacanationbookingsystem.Enum.CenterType;
import com.example.vacanationbookingsystem.Model.Doctor;
import com.example.vacanationbookingsystem.Service.VaccinationCenterService;
import com.example.vacanationbookingsystem.dto.Requestdto.CenterRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.CenterResponseDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
  @Autowired
    VaccinationCenterService vaccinationCenterService;
    @PostMapping("/add")
    public CenterResponseDto addCenter(@RequestBody CenterRequestDto centerRequestDto){

        CenterResponseDto centerResponseDto = vaccinationCenterService.addCenter(centerRequestDto);
        return centerResponseDto;
    }


}
