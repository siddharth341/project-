package com.examly.springapp.controller;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    
    @Autowired
    private BorrowService borrowService;
    
    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@RequestBody Borrow borrow) {
        Borrow saved = borrowService.saveBorrow(borrow);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        List<Borrow> borrows = borrowService.getAllBorrows();
        return ResponseEntity.ok(borrows);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        Borrow borrow = borrowService.getBorrowById(id);
        return ResponseEntity.ok(borrow);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Borrow> updateBorrow(@PathVariable Long id, @RequestBody Borrow borrow) {
        Borrow updated = borrowService.updateBorrow(id, borrow);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
        return ResponseEntity.noContent().build();
    }
}