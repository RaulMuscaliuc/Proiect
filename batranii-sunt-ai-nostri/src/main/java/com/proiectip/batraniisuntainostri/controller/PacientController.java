package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import com.proiectip.batraniisuntainostri.service.PacientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacienti")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    public ResponseEntity<List<Pacient>> getPacienti() {
        return ResponseEntity.ok(pacientService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> adaugaPacient(@RequestBody Pacient pacient) {
        pacientService.adaugaPacient(pacient);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editeazaPacient(@PathVariable("id") String id, @RequestBody Pacient pacient) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacient(@PathVariable("id") String id) {
        pacientService.stergePacient(Long.parseLong(id));
        return ResponseEntity.noContent().build();
    }
}