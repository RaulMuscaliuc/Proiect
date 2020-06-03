package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.persoane.Pacient;
import com.proiectip.batraniisuntainostri.service.PacientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/pacienti")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Pacient>> getPacienti(@RequestParam("role") String role,
                                                     @RequestParam("id") String id) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(pacientService.getAllFromFireBase(role, id));
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Pacient> gasestePacient(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(pacientService.getOne(Long.parseLong(id)));
    }

    /*@PostMapping
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
    }*/
}
