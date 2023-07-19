package com.example.vacanationbookingsystem.Controller;

import com.example.vacanationbookingsystem.Model.Person;
import com.example.vacanationbookingsystem.Service.PersonService;
import com.example.vacanationbookingsystem.dto.Requestdto.AddPersonRequestDto;
import com.example.vacanationbookingsystem.dto.Responsedto.AddPersonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
//    @PostMapping("/add")
//    public ResponseEntity addPerson(@RequestBody Person person){
//       try{
//        Person person1=personService.addPerson(person);
//        return new ResponseEntity<>(person1, HttpStatus.ACCEPTED);
//       }
//       catch (Exception e){
//           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//       }
//
//    }
    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddPersonRequestDto addPersonRequestDto){
        try{
            AddPersonResponseDto personResponseDto=personService.addPerson(addPersonRequestDto);
            return new ResponseEntity<>(personResponseDto,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Email is Already Exits",HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/email")
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail, @RequestParam("newEmail") String newEmail){
        try{
            String response=personService.updateEmail(oldEmail,newEmail);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }
       catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }

    }
}
