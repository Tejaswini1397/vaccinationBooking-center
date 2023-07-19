package com.example.vacanationbookingsystem.Model;

import com.example.vacanationbookingsystem.Enum.DoseType;
import com.example.vacanationbookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int age;
    @Column(unique = true)
    String emailId;
  @Enumerated(EnumType.STRING)
    Gender gender;
  @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Appointment>appointments=new ArrayList<>();
  @ManyToOne
  @JoinColumn
    VaccinationCenter center;
}
