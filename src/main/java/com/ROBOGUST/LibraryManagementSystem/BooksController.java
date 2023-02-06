package com.ROBOGUST.LibraryManagementSystem;

import com.ROBOGUST.LibraryManagementSystem.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ROBOGUST.LibraryManagementSystem.service.BooksService;

import java.util.List;
// @RequestMapping("/books")
@Controller
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
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/register")
    public String register(User user) {
        return "register";
    }

}
