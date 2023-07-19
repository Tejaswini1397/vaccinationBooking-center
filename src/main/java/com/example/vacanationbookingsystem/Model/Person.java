package com.example.vacanationbookingsystem.Model;

import com.example.vacanationbookingsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(unique = true,nullable = false)
    String emailId;
    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean dose1Taken;
    boolean dose2Taken;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Dose>dosesTaken=new ArrayList<>();
    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    Certificate certificate;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Appointment>appointments=new ArrayList<>();
}
