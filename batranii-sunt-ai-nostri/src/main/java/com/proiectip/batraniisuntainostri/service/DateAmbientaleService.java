package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.DateAmbientale;
import com.proiectip.batraniisuntainostri.data.repo.DateAmbientaleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateAmbientaleService {
    private final DateAmbientaleRepo dateAmbientaleRepo;

    public DateAmbientaleService(DateAmbientaleRepo dateAmbientaleRepo) {
        this.dateAmbientaleRepo = dateAmbientaleRepo;
    }

    public List<DateAmbientale> gasesteDateAmbientale(final long pacientId) {
        return dateAmbientaleRepo.gasesteDateAmbientalePentruPacient(pacientId);
    }
}
