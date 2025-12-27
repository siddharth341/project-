package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    
    @Autowired
    private BookCategoryRepo bookCategoryRepo;
    
    @Override
    public BookCategory saveBookCategory(BookCategory bookCategory) {
        return bookCategoryRepo.save(bookCategory);
    }
    
    @Override
    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepo.findAll();
    }
    
    @Override
    public BookCategory getBookCategoryById(Long id) {
        return bookCategoryRepo.findById(id).orElse(null);
    }
    
    @Override
    public BookCategory updateBookCategory(Long id, BookCategory bookCategory) {
        if (bookCategoryRepo.existsById(id)) {
            bookCategory.setCategoryId(id);
            return bookCategoryRepo.save(bookCategory);
        }
        return null;
    }
    
    @Override
    public void deleteBookCategory(Long id) {
        bookCategoryRepo.deleteById(id);
    }
    
    @Override
    public Page<BookCategory> getBookCategoriesWithPagination(Pageable pageable) {
        return bookCategoryRepo.findAll(pageable);
    }
}