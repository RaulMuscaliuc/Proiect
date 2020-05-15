package com.proiectip.batraniisuntainostri.data.repo;

import com.proiectip.batraniisuntainostri.data.model.persoane.Supraveghetor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupraveghetorRepo extends JpaRepository<Supraveghetor, Long> {
    List<Supraveghetor> findAll();
}
