package com.examly.springapp.controller;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {
    
    @Autowired
    private BookCategoryService bookCategoryService;
    
    @PostMapping
    public ResponseEntity<?> createBookCategory(@RequestBody(required = false) BookCategory bookCategory) {
        if (bookCategory == null || bookCategory.getCategoryName() == null || bookCategory.getCategoryName().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        BookCategory saved = bookCategoryService.saveBookCategory(bookCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping
    public ResponseEntity<?> getAllBookCategories() {
        List<BookCategory> categories = bookCategoryService.getAllBookCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookCategoryById(@PathVariable Long id) {
        BookCategory category = bookCategoryService.getBookCategoryById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book category not found");
        }
        return ResponseEntity.ok(category);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateBookCategory(@PathVariable Long id, @RequestBody BookCategory bookCategory) {
        BookCategory updated = bookCategoryService.updateBookCategory(id, bookCategory);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable Long id) {
        bookCategoryService.deleteBookCategory(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<BookCategory>> getBookCategoriesWithPagination(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BookCategory> categories = bookCategoryService.getBookCategoriesWithPagination(pageable);
        return ResponseEntity.ok(categories);
    }
}