package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.DateFiziologice;
import com.proiectip.batraniisuntainostri.data.repo.DateFiziologiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateFiziologiceService {
    private final DateFiziologiceRepo dateFiziologiceRepo;

    public DateFiziologiceService(DateFiziologiceRepo dateFiziologiceRepo) {
        this.dateFiziologiceRepo = dateFiziologiceRepo;
    }

    public List<DateFiziologice> gasesteDateFiziologice(long pacientId) {
        return dateFiziologiceRepo.gasesteDateFiziologicePentruPacient(pacientId);
    }
}
