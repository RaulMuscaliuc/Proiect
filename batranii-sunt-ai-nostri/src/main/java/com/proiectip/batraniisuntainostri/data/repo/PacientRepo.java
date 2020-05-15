package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacientRepo extends JpaRepository<Pacient, Long> {
    List<Pacient> findAll();
}
