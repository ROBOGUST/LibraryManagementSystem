package com.ROBOGUST.LibraryManagementSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository <Books, Long>{
   // @Query("SELECT * FROM Books")
    //List<Books>getAllBooks();



}
