package com.ROBOGUST.LibraryManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ROBOGUST.LibraryManagementSystem.service.BooksService;

import java.util.List;

@RestController
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/hello")
    public String Hello(){

        return "Hello";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Books>>getAllBooks(){

        return booksService.getAllBooks();
    }

}
