package com.proiectip.batraniisuntainostri.service;

import com.proiectip.batraniisuntainostri.data.model.Diagnostic;
import com.proiectip.batraniisuntainostri.data.repo.DiagnosticRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticService {
    private DiagnosticRepo diagnosticRepo;

    public DiagnosticService(DiagnosticRepo diagnosticRepo) {
        this.diagnosticRepo = diagnosticRepo;
    }

    public List<Diagnostic> gasesteDiagnostic(final long pacientId) {
        return diagnosticRepo.gasesteDiagnosticePentruPacient(pacientId);
    }
}
