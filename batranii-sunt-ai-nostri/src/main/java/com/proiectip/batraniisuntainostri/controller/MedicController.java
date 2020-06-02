/*
package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.persoane.Medic;
import com.proiectip.batraniisuntainostri.service.MedicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medici")
public class MedicController {

    private final MedicService medicService;

    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @GetMapping
    public ResponseEntity<List<Medic>> getMedici() {
        return ResponseEntity.ok(medicService.getAll());
    }
}
*/
