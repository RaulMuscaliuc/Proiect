package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.Alergie;
import com.proiectip.batraniisuntainostri.service.AlergiiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class AlergiController {
    private final AlergiiService alergiiService;

    public AlergiController(AlergiiService alergiiService) {
        this.alergiiService = alergiiService;
    }


    @CrossOrigin
    @PostMapping("/pacienti/{id}/alergie")
    public ResponseEntity<Void> salveazaAlergie(@PathVariable("id") String id,
                                                @RequestBody Alergie alergie) throws ExecutionException, InterruptedException {
        alergiiService.salveazaAlergie(alergie);
        return ResponseEntity.noContent().build();
    }
}
