package com.examly.springapp.repository;

import com.examly.springapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByBookCategory_CategoryName(String categoryName);
    List<Book> findByTitle(String title);
}