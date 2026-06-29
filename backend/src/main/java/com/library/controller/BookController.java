package com.library.controller;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/books") @CrossOrigin("*")
public class BookController {
 private final BookRepository repo;
 public BookController(BookRepository repo){this.repo=repo;}
 @GetMapping public List<Book> all(){return repo.findAll();}
 @PostMapping public Book add(@RequestBody Book b){return repo.save(b);}
 @GetMapping("/search") public List<Book> search(@RequestParam String title){return repo.findByTitleContainingIgnoreCase(title);}
}