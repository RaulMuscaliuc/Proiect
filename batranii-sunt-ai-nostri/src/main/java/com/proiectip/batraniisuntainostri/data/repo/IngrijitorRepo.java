package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.persoane.Ingrijitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngrijitorRepo extends JpaRepository<Ingrijitor, Long> {
    List<Ingrijitor> findAll();
}
