package com.example.vacanationbookingsystem.Service;

import com.example.vacanationbookingsystem.Model.VaccinationCenter;
import com.example.vacanationbookingsystem.Repository.VaccinationCenterRepository;
import com.example.vacanationbookingsystem.dto.Requestdto.CenterRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.CenterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto){
        //request dto -> entity
        VaccinationCenter vaccinationCenter=new VaccinationCenter();
        vaccinationCenter.setCentreName(centerRequestDto.getCenterName());
        vaccinationCenter.setCentreType(centerRequestDto.getCenterType());
        vaccinationCenter.setAddress(centerRequestDto.getAddress());

        //save entity to db
        VaccinationCenter savedCenter=vaccinationCenterRepository.save(vaccinationCenter);

        //entity to response dto
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterName(savedCenter.getCentreName());
        centerResponseDto.setCenterType(savedCenter.getCentreType());
        centerResponseDto.setAddress(savedCenter.getAddress());

        return centerResponseDto;

    }

}
