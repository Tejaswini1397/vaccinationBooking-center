package com.example.vacanationbookingsystem.Service;

import com.example.vacanationbookingsystem.Model.Appointment;
import com.example.vacanationbookingsystem.Model.Doctor;
import com.example.vacanationbookingsystem.Model.Person;
import com.example.vacanationbookingsystem.Model.VaccinationCenter;
import com.example.vacanationbookingsystem.Repository.AppointmentRepository;
import com.example.vacanationbookingsystem.Repository.DoctorRepository;
import com.example.vacanationbookingsystem.Repository.PersonRepository;
import com.example.vacanationbookingsystem.dto.Requestdto.BookAppointmentRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.BookAppointmentResponseDto;
import com.example.vacanationbookingsystem.dto.Responsedto.CenterResponseDto;
import com.example.vacanationbookingsystem.exception.DoctorNotFoundException;
import com.example.vacanationbookingsystem.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public BookAppointmentResponseDto bookAppointment(BookAppointmentRequestDto bookAppointmentRequestDto){
        Optional<Person>optionalPerson=personRepository.findById(bookAppointmentRequestDto.getPersonId());
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Invalid personId");
        }
        Optional<Doctor>optionalDoctor=doctorRepository.findById(bookAppointmentRequestDto.getDoctorId());
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid DoctorId");
        }
        Person person=optionalPerson.get();
        Doctor doctor=optionalDoctor.get();

        //create appointment
        Appointment appointment=new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment=appointmentRepository.save(appointment);

        doctor.getAppointments().add(savedAppointment);
        person.getAppointments().add(savedAppointment);

        Doctor savedDoctor=doctorRepository.save(doctor);
        Person savedPerson=personRepository.save(person);
        VaccinationCenter savedCenter=savedDoctor.getCenter();

        //send Email
        String text="Congrats!! "+savedPerson.getName()+" Your Appointment has been booked with Doctor "+
                savedDoctor.getName()+" .  Your vaccination center is : "+savedCenter.getCentreName()+
                " Please reached at this Address "+savedCenter.getAddress()+" at this time : "+
                savedAppointment.getAppointmentDate()+ " Thank you!!";
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("nitakhairnar1397@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congrats Appointment Booked !!");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);

        //prepare response dto
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterName(savedCenter.getCentreName());
        centerResponseDto.setCenterType(savedCenter.getCentreType());
        centerResponseDto.setAddress(savedCenter.getAddress());

        BookAppointmentResponseDto bookAppointmentResponseDto = new BookAppointmentResponseDto();
        bookAppointmentResponseDto.setPersonName(savedPerson.getName());
        bookAppointmentResponseDto.setDoctorName(savedDoctor.getName());
        bookAppointmentResponseDto.setAppointmentId(savedAppointment.getAppointmentId());
        bookAppointmentResponseDto.setAppointmentDate(savedAppointment.getAppointmentDate());
        bookAppointmentResponseDto.setCenterResponseDto(centerResponseDto);

        return bookAppointmentResponseDto;

    }

}
