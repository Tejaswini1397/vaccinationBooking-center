package com.example.vacanationbookingsystem.dto.Responsedto;

import com.example.vacanationbookingsystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorResponseDto {
    String name;
    String message;
    CenterResponseDto centerResponseDto;
}
