package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.Tratament;
import com.proiectip.batraniisuntainostri.service.TratamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class TratamentController {

    private final TratamentService tratamentService;

    public TratamentController(TratamentService tratamentService) {
        this.tratamentService = tratamentService;
    }

    @GetMapping("/pacienti/{id}/tratamente")
    public ResponseEntity<List<Tratament>> gasesteTratamente(@PathVariable("id") String pacientId) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(tratamentService.gasesteTratamente(Long.parseLong(pacientId)));
    }

   /* @GetMapping("/tratamente/{id}")
    public ResponseEntity<Tratament> gasesteTratament(@PathVariable("id") String id) {
        return ResponseEntity.ok(tratamentService.gasesteTratament(Long.parseLong(id)));
    }

    @PutMapping("/tratamente")
    public ResponseEntity<Void> gasesteTratament(@RequestBody Tratament tratament) {
        tratamentService.salveazaTratament(tratament);
        return ResponseEntity.noContent().build();
    }*/

}
