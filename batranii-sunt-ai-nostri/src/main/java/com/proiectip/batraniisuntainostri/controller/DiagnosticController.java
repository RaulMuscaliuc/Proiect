package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.Diagnostic;
import com.proiectip.batraniisuntainostri.service.DiagnosticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class DiagnosticController {

    private final DiagnosticService diagnosticService;

    public DiagnosticController(DiagnosticService diagnosticService) {
        this.diagnosticService = diagnosticService;
    }

    @CrossOrigin
    @PostMapping("/pacienti/{id}/diagnostic")
    public ResponseEntity<Void> salveazaDiagnostic(@PathVariable("id") String id,
                                                   @RequestBody Diagnostic diagnostic) throws ExecutionException, InterruptedException {
        diagnosticService.salveazaDiagnostic(diagnostic);
        return ResponseEntity.noContent().build();
    }
}
