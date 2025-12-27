package com.examly.springapp.service;

import com.examly.springapp.model.Fine;
import java.util.List;

public interface FineService {
    Fine saveFine(Fine fine);
    List<Fine> getAllFines();
    Fine getFineById(Long id);
    Fine updateFine(Long id, Fine fine);
    void deleteFine(Long id);
}