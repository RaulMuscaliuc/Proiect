package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.Alergie;
import com.proiectip.batraniisuntainostri.data.repo.AlergieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergiiService {
    private final AlergieRepo alergieRepo;

    public AlergiiService(AlergieRepo alergieRepo) {
        this.alergieRepo = alergieRepo;
    }

    public List<Alergie> gasesteAlergii(long pacientId) {
        return alergieRepo.gasesteAlergiiPentruPacient(pacientId);
    }
}
