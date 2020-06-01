package com.proiectip.batraniisuntainostri.controller;

import com.proiectip.batraniisuntainostri.data.model.DateFiziologice;
import com.proiectip.batraniisuntainostri.service.DateFiziologiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ambientale")
public class DateFiziologiceController {
    private final DateFiziologiceService dateFiziologiceService;

    public DateFiziologiceController(DateFiziologiceService dateFiziologiceService) {
        this.dateFiziologiceService = dateFiziologiceService;
    }
    
    @GetMapping("/{pacientId}")
    public ResponseEntity<List<DateFiziologice>> gasesteDateAmbientale(@PathVariable("pacientId") String pacientId) {
        return ResponseEntity.ok(dateFiziologiceService.gasesteDateFiziologice(Long.parseLong(pacientId)));
    }
}
