package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.persoane.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicRepo extends JpaRepository<Medic, Long> {
    List<Medic> findAll();
}
