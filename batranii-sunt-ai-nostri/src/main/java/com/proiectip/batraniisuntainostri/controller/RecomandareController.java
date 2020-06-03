package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.Recomandare;
import com.proiectip.batraniisuntainostri.service.RecomandareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class RecomandareController {

    private final RecomandareService recomandareService;

    public RecomandareController(RecomandareService recomandareService) {
        this.recomandareService = recomandareService;
    }

    @CrossOrigin
    @GetMapping("/pacienti/{id}/recomandari")
    public ResponseEntity<List<Recomandare>> gasesteRecomandari(@PathVariable("id") String pacientId) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(recomandareService.gasesteRecomandari(Long.parseLong(pacientId)));
    }


    @CrossOrigin
    @PostMapping("/pacienti/{id}/recomandare")
    public ResponseEntity<Void> salveazaRecomandare(@PathVariable("id") String id,
                                                    @RequestBody Recomandare recomandare) throws ExecutionException, InterruptedException {
        recomandareService.salveazaRecomandare(recomandare);
        return ResponseEntity.noContent().build();
    }

}
