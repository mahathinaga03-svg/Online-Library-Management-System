package com.library.controller;
import com.library.entity.Book;
import com.library.entity.IssueRecord;
import com.library.repository.BookRepository;
import com.library.repository.IssueRecordRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@RestController @RequestMapping("/api/library") @CrossOrigin("*")
public class LibraryController {
 private final BookRepository bookRepo; private final IssueRecordRepository issueRepo;
 public LibraryController(BookRepository b, IssueRecordRepository i){bookRepo=b;issueRepo=i;}
 @PostMapping("/issue")
 public IssueRecord issue(@RequestParam Long bookId,@RequestParam Long userId){
  Book book=bookRepo.findById(bookId).orElseThrow();
  if(book.getQuantity()<=0) throw new RuntimeException("Book unavailable");
  book.setQuantity(book.getQuantity()-1); bookRepo.save(book);
  IssueRecord r=new IssueRecord(); r.setBookId(bookId); r.setUserId(userId);
  r.setIssueDate(LocalDate.now()); r.setDueDate(LocalDate.now().plusDays(14));
  return issueRepo.save(r);
 }
 @PostMapping("/return")
 public IssueRecord ret(@RequestParam Long recordId){
  IssueRecord r=issueRepo.findById(recordId).orElseThrow();
  r.setReturnDate(LocalDate.now());
  long late=ChronoUnit.DAYS.between(r.getDueDate(),LocalDate.now());
  r.setFine(late>0?late*5:0);
  Book b=bookRepo.findById(r.getBookId()).orElseThrow();
  b.setQuantity(b.getQuantity()+1); bookRepo.save(b);
  return issueRepo.save(r);
 }
}