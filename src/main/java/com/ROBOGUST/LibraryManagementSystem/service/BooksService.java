package com.ROBOGUST.LibraryManagementSystem.service;

import com.ROBOGUST.LibraryManagementSystem.Books;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {


    ResponseEntity<List<Books>>getAllBooks();

    ResponseEntity<Books> getSelectedBooks();

}
