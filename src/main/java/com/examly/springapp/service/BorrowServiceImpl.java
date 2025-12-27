package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.repository.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    
    @Autowired
    private BorrowRepo borrowRepo;
    
    @Override
    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepo.save(borrow);
    }
    
    @Override
    public List<Borrow> getAllBorrows() {
        return borrowRepo.findAll();
    }
    
    @Override
    public Borrow getBorrowById(Long id) {
        return borrowRepo.findById(id).orElse(null);
    }
    
    @Override
    public Borrow updateBorrow(Long id, Borrow borrow) {
        if (borrowRepo.existsById(id)) {
            borrow.setBorrowId(id);
            return borrowRepo.save(borrow);
        }
        return null;
    }
    
    @Override
    public void deleteBorrow(Long id) {
        borrowRepo.deleteById(id);
    }
}