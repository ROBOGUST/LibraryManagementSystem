package com.ROBOGUST.LibraryManagementSystem;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    @Column(name = "genre")
    private String genre;

    @Column(name = "ISBN")
    private long ISBN;

    public Books(String author, String title, String genre, long ISBN){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.ISBN = ISBN;
    }
    public Books() {

    }
}
