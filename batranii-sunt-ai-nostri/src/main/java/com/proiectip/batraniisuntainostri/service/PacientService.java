package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.Alergie;
import com.proiectip.batraniisuntainostri.data.model.DateAmbientale;
import com.proiectip.batraniisuntainostri.data.model.DateFiziologice;
import com.proiectip.batraniisuntainostri.data.model.Diagnostic;
import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import com.proiectip.batraniisuntainostri.data.repo.PacientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    private final PacientRepo pacientRepo;
    private final DiagnosticService diagnosticService;
    private final AlergiiService alergiiService;
    private final DateFiziologiceService dateFiziologiceService;
    private final DateAmbientaleService dateAmbientaleService;

    public PacientService(PacientRepo pacientRepo, DiagnosticService diagnosticService,
                          AlergiiService alergiiService, DateFiziologiceService dateFiziologiceService,
                          DateAmbientaleService dateAmbientaleService) {
        this.pacientRepo = pacientRepo;
        this.diagnosticService = diagnosticService;
        this.alergiiService = alergiiService;
        this.dateFiziologiceService = dateFiziologiceService;
        this.dateAmbientaleService = dateAmbientaleService;
    }

    public List<Pacient> getAll() {
        return pacientRepo.findAll();
    }

    public Pacient getOne(long id) {
        Pacient pacient =  pacientRepo.findByid(id);

        List<Diagnostic> diagnostice = diagnosticService.gasesteDiagnostic(id);
        List<Alergie> alergii = alergiiService.gasesteAlergii(id);
        List<DateFiziologice> dateFiziologice = dateFiziologiceService.gasesteDateFiziologice(id);
        List<DateAmbientale> dateAmbientale = dateAmbientaleService.gasesteDateAmbientale(id);

        pacient.setDateAmbientale(dateAmbientale);
        pacient.setDateFiziologice(dateFiziologice);
        pacient.setDiagnostice(diagnostice);
        pacient.setAlergii(alergii);

        return pacient;
    }

    public void adaugaPacient(final Pacient pacient) {
        pacientRepo.save(pacient);
    }

    public void stergePacient(final long id) {
        pacientRepo.deleteById(id);
    }
}
