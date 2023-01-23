package service;

import com.ROBOGUST.LibraryManagementSystem.Books;
import com.ROBOGUST.LibraryManagementSystem.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    public ResponseEntity<List<Books>> getAllBooks;
}
