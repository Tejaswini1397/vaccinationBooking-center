package com.example.vacanationbookingsystem.Service;

import com.example.vacanationbookingsystem.Model.Doctor;
import com.example.vacanationbookingsystem.Model.VaccinationCenter;
import com.example.vacanationbookingsystem.Repository.DoctorRepository;
import com.example.vacanationbookingsystem.Repository.VaccinationCenterRepository;
import com.example.vacanationbookingsystem.dto.Requestdto.CenterRequestDto;
import com.example.vacanationbookingsystem.dto.Requestdto.DoctorRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.CenterResponseDto;
import com.example.vacanationbookingsystem.dto.Responsedto.DoctorResponseDto;
import com.example.vacanationbookingsystem.exception.CenterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Autowired
    DoctorRepository doctorRepository;
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto){

        Optional<VaccinationCenter>vaccinationCenterOptional=vaccinationCenterRepository.findById(doctorRequestDto.getCenterId());
        if(vaccinationCenterOptional.isEmpty()){
            throw new CenterNotFoundException("Sorry! wrong centerId");
        }
        VaccinationCenter center=vaccinationCenterOptional.get();

        //create doctor entity
        Doctor doctor=new Doctor();
        doctor.setName(doctorRequestDto.getName());
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setCenter(center);
        //add in center doctor list
        center.getDoctors().add(doctor);
        VaccinationCenter savedCenter=vaccinationCenterRepository.save(center);//save both center and doctor

        //prepare response dto
        List<Doctor> doctorList=savedCenter.getDoctors();

        Doctor lastSavedDoctors=doctorList.get(doctorList.size()-1);
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterType(savedCenter.getCentreType());
        centerResponseDto.setCenterName(savedCenter.getCentreName());
        centerResponseDto.setAddress(savedCenter.getAddress());

        DoctorResponseDto doctorResponseDto=new DoctorResponseDto();
        doctorResponseDto.setName(lastSavedDoctors.getName());
        doctorResponseDto.setMessage("Congrats !! You have registered!");
        doctorResponseDto.setCenterResponseDto(centerResponseDto);
        return doctorResponseDto;
    }
    public List<String>getAgeGreaterThan(int age){
        List<Doctor>doctors=doctorRepository.getByAgeGreaterThan(age);
        List<String>ans=new ArrayList<>();
        for(Doctor d:doctors){
            ans.add(d.getName());
        }
        return ans;
    }
}
