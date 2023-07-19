package com.example.vacanationbookingsystem.Repository;

import com.example.vacanationbookingsystem.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
