package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.DateFiziologice;
import com.proiectip.batraniisuntainostri.service.DateFiziologiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/ambientale")
public class DateFiziologiceController {
    private final DateFiziologiceService dateFiziologiceService;

    public DateFiziologiceController(DateFiziologiceService dateFiziologiceService) {
        this.dateFiziologiceService = dateFiziologiceService;
    }

    @CrossOrigin
    @GetMapping("/{pacientId}")
    public ResponseEntity<List<DateFiziologice>> gasesteDateAmbientale(@PathVariable("pacientId") String pacientId) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(dateFiziologiceService.gasesteDateFiziologice(Long.parseLong(pacientId)));
    }
}
