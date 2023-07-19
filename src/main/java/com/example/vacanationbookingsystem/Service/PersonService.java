package com.example.vacanationbookingsystem.Service;

import com.example.vacanationbookingsystem.Model.Person;
import com.example.vacanationbookingsystem.Repository.PersonRepository;
import com.example.vacanationbookingsystem.dto.Requestdto.AddPersonRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.AddPersonResponseDto;
import com.example.vacanationbookingsystem.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
@Autowired
    PersonRepository personRepository;
//    public Person addPerson(Person person) {
//        person.setDose1Taken(false);
//        person.setDose1Taken(false);
//        person.setCertificate(null);
//       Person savePerson= personRepository.save(person);
//       return savePerson;
//    }
    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto){
        Person person=new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setGender(addPersonRequestDto.getGender());

        person.setDose1Taken(false);
        person.setDose2Taken(false);
        person.setCertificate(null);

        Person savedPerson=personRepository.save(person);
        AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMessage("Congrats you Have Been Registered");
        return addPersonResponseDto;
    }
    public String updateEmail(String oldEmail, String newEmail){
        Person person=personRepository.findByEmailId(oldEmail);
        if(person==null){
            throw new PersonNotFoundException("Sorry Email Doesn't Exist");
        }
        person.setEmailId(newEmail);
        personRepository.save(person);
        return "Congrats Your Email Updated";
    }
}
