package com.example.vacanationbookingsystem.dto.Requestdto;

import com.example.vacanationbookingsystem.Enum.CenterType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CenterRequestDto {
    String centerName;
    @Enumerated(value = EnumType.STRING)
    CenterType centerType;
    String address;
}
