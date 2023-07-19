package com.example.vacanationbookingsystem.dto.Responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookAppointmentResponseDto {
    String personName;
    String doctorName;
    String appointmentId;
    @CreationTimestamp
    Date appointmentDate;
    CenterResponseDto centerResponseDto;


}
