package com.ROBOGUST.LibraryManagementSystem.service;

import com.ROBOGUST.LibraryManagementSystem.Books;
import com.ROBOGUST.LibraryManagementSystem.BooksRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
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

    @Override
    public ResponseEntity<Books> getSelectedBooks(){
        try{
            String bookApi = "http://openlibrary.org/search.json?q=";
            String input = "Harry Potter";
            RestTemplate restTemplate = new RestTemplate();
            Books book = new Books();

            String bookSearch = restTemplate.getForObject(bookApi.concat(input), String.class);
            //System.out.println(bookSearch);
            for (int i = 0 ; i < bookSearch.length() ; i++){
                if (bookSearch.contains("title")){
                    book.setTitle(bookSearch);
                }
            }
            return new ResponseEntity<Books>(book, HttpStatus.OK );
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
