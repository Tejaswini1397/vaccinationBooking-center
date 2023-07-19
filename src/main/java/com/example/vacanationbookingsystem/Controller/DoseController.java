package com.example.vacanationbookingsystem.Controller;

import com.example.vacanationbookingsystem.Enum.DoseType;
import com.example.vacanationbookingsystem.Model.Dose;
import com.example.vacanationbookingsystem.Service.DoseService;
import com.example.vacanationbookingsystem.dto.Requestdto.BookDose1RequestDto;
import com.example.vacanationbookingsystem.dto.Requestdto.BookDose2RequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;
//    @PostMapping("/get_dose_1")
//    public ResponseEntity getDose1(@RequestParam("personId") int personId ,@RequestParam("doseType") DoseType doseType){
//        try{
//            Dose doseTake=doseService.getDose1(personId,doseType);
//            return new ResponseEntity(doseTake, HttpStatus.CREATED);
//        }
//        catch (Exception e){
//            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }
    static boolean dose1Taken;
@PostMapping("/get_dose_1")
public ResponseEntity getDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto){

    try{
        Dose doseTake = doseService.getDose1(bookDose1RequestDto);
        dose1Taken=true;
        return new ResponseEntity(doseTake,HttpStatus.CREATED);
    }
    catch (Exception e){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
    @PostMapping("/get_dose_2")
    public ResponseEntity getDose2(@RequestBody BookDose2RequestDto bookDose2RequestDto){

        try{
           if(dose1Taken==true) {
               Dose doseTake = doseService.getDose2(bookDose2RequestDto);
               return new ResponseEntity(doseTake, HttpStatus.CREATED);
           } else {
               return new ResponseEntity("Dose 1 not taken yet", HttpStatus.BAD_REQUEST);
           }
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
