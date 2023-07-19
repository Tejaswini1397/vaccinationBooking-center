package com.example.vacanationbookingsystem.dto.Responsedto;

import com.example.vacanationbookingsystem.Enum.CenterType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CenterResponseDto {
    String centerName;
    CenterType centerType;
    String address;
}
