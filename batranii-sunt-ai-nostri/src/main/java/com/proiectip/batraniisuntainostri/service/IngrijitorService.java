package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.persoane.Ingrijitor;
import com.proiectip.batraniisuntainostri.data.repo.IngrijitorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngrijitorService {

    private final IngrijitorRepo ingrijitorRepo;

    public IngrijitorService(IngrijitorRepo ingrijitorRepo) {
        this.ingrijitorRepo = ingrijitorRepo;
    }

    public List<Ingrijitor> getAll() {
        return ingrijitorRepo.findAll();
    }
}
