package com.example.vacanationbookingsystem.dto.Responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonResponseDto {
    String name;
    String message;
}
