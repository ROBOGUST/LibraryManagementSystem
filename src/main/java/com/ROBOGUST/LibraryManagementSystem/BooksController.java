package com.ROBOGUST.LibraryManagementSystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @GetMapping("/hello")
    public String Hello(){

        return "Hello";
    }

}
