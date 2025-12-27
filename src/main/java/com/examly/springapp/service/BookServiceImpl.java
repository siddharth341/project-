package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import com.examly.springapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookRepo bookRepo;
    
    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    
    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    
    @Override
    public Book updateBook(Long id, Book book) {
        if (bookRepo.existsById(id)) {
            book.setBookId(id);
            return bookRepo.save(book);
        }
        return null;
    }
    
    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
    
    @Override
    public List<Book> getBooksByCategoryName(String categoryName) {
        return bookRepo.findByBookCategory_CategoryName(categoryName);
    }
    
    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findByTitle(title);
    }
}