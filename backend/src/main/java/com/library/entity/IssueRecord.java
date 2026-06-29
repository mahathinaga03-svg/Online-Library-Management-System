package com.library.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class IssueRecord {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long bookId,userId; private LocalDate issueDate,dueDate,returnDate; private double fine;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public Long getBookId(){return bookId;} public void setBookId(Long bookId){this.bookId=bookId;}
 public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;}
 public LocalDate getIssueDate(){return issueDate;} public void setIssueDate(LocalDate issueDate){this.issueDate=issueDate;}
 public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate dueDate){this.dueDate=dueDate;}
 public LocalDate getReturnDate(){return returnDate;} public void setReturnDate(LocalDate returnDate){this.returnDate=returnDate;}
 public double getFine(){return fine;} public void setFine(double fine){this.fine=fine;}
}