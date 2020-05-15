package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.persoane.Medic;
import com.proiectip.batraniisuntainostri.data.repo.MedicRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    private final MedicRepo medicRepo;

    public MedicService(MedicRepo medicRepo) {
        this.medicRepo = medicRepo;
    }

    public List<Medic> getAll() {
        return medicRepo.findAll();
    }
}
