package com.example.vacanationbookingsystem.Model;

import com.example.vacanationbookingsystem.Enum.CenterType;
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
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String centreName;

    @Enumerated(value = EnumType.STRING)
    CenterType centreType;

    String address;
    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
    List<Doctor>doctors=new ArrayList<>();
}
