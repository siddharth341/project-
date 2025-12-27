package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookCategoryService {
    BookCategory saveBookCategory(BookCategory bookCategory);
    List<BookCategory> getAllBookCategories();
    BookCategory getBookCategoryById(Long id);
    BookCategory updateBookCategory(Long id, BookCategory bookCategory);
    void deleteBookCategory(Long id);
    Page<BookCategory> getBookCategoriesWithPagination(Pageable pageable);
}