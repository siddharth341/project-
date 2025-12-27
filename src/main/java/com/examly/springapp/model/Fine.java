package com.examly.springapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fineId;
    
    @OneToOne
    @JoinColumn(name = "borrow_id")
    private Borrow borrow;
    
    private BigDecimal amount;
    private boolean paid;
    
    public Fine() {}
    
    public Long getFineId() { return fineId; }
    public void setFineId(Long fineId) { this.fineId = fineId; }
    
    public Borrow getBorrow() { return borrow; }
    public void setBorrow(Borrow borrow) { this.borrow = borrow; }
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}