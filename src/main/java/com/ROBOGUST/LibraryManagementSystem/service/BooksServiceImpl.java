package com.ROBOGUST.LibraryManagementSystem.service;

import com.ROBOGUST.LibraryManagementSystem.Books;
import com.ROBOGUST.LibraryManagementSystem.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;


    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
@Override
    public ResponseEntity<List<Books>>getAllBooks(){
    try {
        List<Books> books = new ArrayList<>();
        booksRepository.findAll().forEach(books::add);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
    }
}
}
