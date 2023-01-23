package service;

import com.ROBOGUST.LibraryManagementSystem.Books;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public interface BooksService {


    ResponseEntity<List<Books>>getAllBooks();
}
