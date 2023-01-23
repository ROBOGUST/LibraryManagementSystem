package com.ROBOGUST.LibraryManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BooksServiceImpl;

import java.util.List;

@RestController
public class BooksController {
    private BooksServiceImpl booksServiceImpl;

    public BooksController(BooksServiceImpl booksServiceImpl) {
        this.booksServiceImpl = booksServiceImpl;
    }

    @GetMapping("/hello")
    public String Hello(){

        return "Hello";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Books>>getAllBooks(){

        return booksServiceImpl.getAllBooks();
    }

}
