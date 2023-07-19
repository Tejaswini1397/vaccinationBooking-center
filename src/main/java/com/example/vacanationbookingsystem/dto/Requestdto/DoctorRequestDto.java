package com.example.vacanationbookingsystem.dto.Requestdto;

import com.example.vacanationbookingsystem.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorRequestDto {
    Integer centerId;
    String name;
    int age;
    String emailId;
    Gender gender;

}
