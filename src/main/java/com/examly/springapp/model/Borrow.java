package com.examly.springapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowId;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    
    private LocalDate borrowDate;
    private LocalDate returnDate;
    
    public Borrow() {}
    
    public Long getBorrowId() { return borrowId; }
    public void setBorrowId(Long borrowId) { this.borrowId = borrowId; }
    
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
    
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}