package com.example.vacanationbookingsystem.dto.Requestdto;

import com.example.vacanationbookingsystem.Enum.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonRequestDto {
    String name;
    int age;
    String emailId;
    Gender gender;
}
