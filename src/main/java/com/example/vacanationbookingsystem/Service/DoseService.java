package com.example.vacanationbookingsystem.Service;

import com.example.vacanationbookingsystem.Enum.DoseType;
import com.example.vacanationbookingsystem.Model.Dose;
import com.example.vacanationbookingsystem.Model.Person;
import com.example.vacanationbookingsystem.Repository.DoseRepository;
import com.example.vacanationbookingsystem.Repository.PersonRepository;
import com.example.vacanationbookingsystem.dto.Requestdto.BookDose1RequestDto;
import com.example.vacanationbookingsystem.dto.Requestdto.BookDose2RequestDto;
import com.example.vacanationbookingsystem.exception.DoseAlreadyTakenException;
import com.example.vacanationbookingsystem.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PersonRepository personRepository;
//    public Dose getDose1(int personId, DoseType doseType){
//        Optional<Person>optionalPerson=personRepository.findById(personId);
//        //check if exist or not
//        if(!optionalPerson.isPresent()){
//            throw new PersonNotFoundException("Invalid PersonId");
//        }
//        Person person=optionalPerson.get();
//        if(person.isDose1Taken()){
//            throw new DoseAlreadyTakenException("Does 1 is Already");
//        }
//        Dose dose=new Dose();
//        dose.setDoseId(String.valueOf(UUID.randomUUID()));
//        dose.setDoseType(doseType);
//        dose.setPerson(person);
//        person.setDose1Taken(true);
//        person.getDoesTaken().add(dose);
//        personRepository.save(person);
//        return doseRepository.save(dose);
//    }
public Dose getDose1(BookDose1RequestDto bookDose1RequestDto) {

    Optional<Person> optionalPerson = personRepository.findById(bookDose1RequestDto.getPersonId());

    // check if person exists or not
    if(!optionalPerson.isPresent()){
        throw new PersonNotFoundException("Invalid PersonId");
    }

    Person person = optionalPerson.get();
    // check if dose 1 is already taken
    if(person.isDose1Taken()){
        throw new DoseAlreadyTakenException("Dose 1 already taken");
    }

    // Create a Dose from RequestDto
    Dose dose = new Dose();
    dose.setDoseId(String.valueOf(UUID.randomUUID()));
    dose.setDoseType(bookDose1RequestDto.getDoseType());
    dose.setPerson(person);

    person.setDose1Taken(true);
    person.getDosesTaken().add(dose);
    Person savedPerson = personRepository.save(person);

    return savedPerson.getDosesTaken().get(0);
}

    public Dose getDose2(BookDose2RequestDto bookDose2RequestDto) {
        Optional<Person> optionalPerson = personRepository.findById(bookDose2RequestDto.getPersonId());

        // check if person exists or not
        if(!optionalPerson.isPresent()){
            throw new PersonNotFoundException("Invalid PersonId");
        }

        Person person = optionalPerson.get();
        // check if dose 1 is already taken
        if(person.isDose2Taken()){
            throw new DoseAlreadyTakenException("Dose 2 already taken");
        }

        // Create a Dose from RequestDto
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose2RequestDto.getDoseType());
        dose.setPerson(person);

        person.setDose2Taken(true);
        person.getDosesTaken().add(dose);
        Person savedPerson = personRepository.save(person);

        return savedPerson.getDosesTaken().get(0);
    }
}
