package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.persoane.Supraveghetor;
import com.proiectip.batraniisuntainostri.service.SupraveghetorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supraveghetori")
public class SupraveghetorController {

    private final SupraveghetorService supraveghetorService;

    public SupraveghetorController(SupraveghetorService supraveghetorService) {
        this.supraveghetorService = supraveghetorService;
    }

    @GetMapping
    public ResponseEntity<List<Supraveghetor>> getSupraveghetori() {
        return ResponseEntity.ok(supraveghetorService.getAll());
    }
}
