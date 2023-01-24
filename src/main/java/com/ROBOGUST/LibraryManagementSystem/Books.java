package com.ROBOGUST.LibraryManagementSystem;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "author")
    private String author;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "ISBN")
    private Long ISBN;
    @Column(name = "heart")
    private Boolean heart;

    public Books(String author, String title, String genre, Long ISBN, Boolean heart){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.ISBN = ISBN;
        this.heart = heart;
    }
}
