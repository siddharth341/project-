package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;
import java.util.List;

public interface BorrowService {
    Borrow saveBorrow(Borrow borrow);
    List<Borrow> getAllBorrows();
    Borrow getBorrowById(Long id);
    Borrow updateBorrow(Long id, Borrow borrow);
    void deleteBorrow(Long id);
}