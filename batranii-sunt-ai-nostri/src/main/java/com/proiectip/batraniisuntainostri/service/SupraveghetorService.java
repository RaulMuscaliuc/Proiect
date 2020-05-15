package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.persoane.Supraveghetor;
import com.proiectip.batraniisuntainostri.data.repo.SupraveghetorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupraveghetorService {

    private final SupraveghetorRepo supraveghetorRepo;

    public SupraveghetorService(SupraveghetorRepo supraveghetorRepo) {
        this.supraveghetorRepo = supraveghetorRepo;
    }

    public List<Supraveghetor> getAll() {
        return supraveghetorRepo.findAll();
    }
}
