package com.examly.springapp.service;

import com.examly.springapp.model.Fine;
import com.examly.springapp.repository.FineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FineServiceImpl implements FineService {
    
    @Autowired
    private FineRepo fineRepo;
    
    @Override
    public Fine saveFine(Fine fine) {
        return fineRepo.save(fine);
    }
    
    @Override
    public List<Fine> getAllFines() {
        return fineRepo.findAll();
    }
    
    @Override
    public Fine getFineById(Long id) {
        return fineRepo.findById(id).orElse(null);
    }
    
    @Override
    public Fine updateFine(Long id, Fine fine) {
        if (fineRepo.existsById(id)) {
            fine.setFineId(id);
            return fineRepo.save(fine);
        }
        return null;
    }
    
    @Override
    public void deleteFine(Long id) {
        fineRepo.deleteById(id);
    }
}