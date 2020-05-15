package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.persoane.Ingrijitor;
import com.proiectip.batraniisuntainostri.service.IngrijitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingrijitori")
public class IngrijitorController {

    private final IngrijitorService ingrijitorService;

    public IngrijitorController(IngrijitorService ingrijitorService) {
        this.ingrijitorService = ingrijitorService;
    }

    @GetMapping
    public ResponseEntity<List<Ingrijitor>> getIngrijitor() {
        return ResponseEntity.ok(ingrijitorService.getAll());
    }
}
