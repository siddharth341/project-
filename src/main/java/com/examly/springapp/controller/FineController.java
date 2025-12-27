package com.examly.springapp.controller;

import com.examly.springapp.model.Fine;
import com.examly.springapp.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fines")
public class FineController {
    
    @Autowired
    private FineService fineService;
    
    @PostMapping
    public ResponseEntity<Fine> createFine(@RequestBody Fine fine) {
        Fine saved = fineService.saveFine(fine);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<Fine>> getAllFines() {
        List<Fine> fines = fineService.getAllFines();
        return ResponseEntity.ok(fines);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Fine> getFineById(@PathVariable Long id) {
        Fine fine = fineService.getFineById(id);
        return ResponseEntity.ok(fine);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Fine> updateFine(@PathVariable Long id, @RequestBody Fine fine) {
        Fine updated = fineService.updateFine(id, fine);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFine(@PathVariable Long id) {
        fineService.deleteFine(id);
        return ResponseEntity.noContent().build();
    }
}