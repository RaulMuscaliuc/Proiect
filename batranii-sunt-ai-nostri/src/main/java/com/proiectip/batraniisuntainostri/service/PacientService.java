package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import com.proiectip.batraniisuntainostri.data.repo.PacientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    public final PacientRepo pacientRepo;

    public PacientService(PacientRepo pacientRepo) {
        this.pacientRepo = pacientRepo;
    }

    public List<Pacient> getAll() {
        return pacientRepo.findAll();
    }

    public void adaugaPacient(final Pacient pacient) {
        pacientRepo.save(pacient);
    }

    public void stergePacient(final long id) {
        pacientRepo.deleteById(id);
    }
}
