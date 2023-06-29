package ua.multitenanttestapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "library")
public class Book {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "namebook")
    private String nameBook;

    @Column(name = "author")
    private String author;

    @Column(name = "releasedate")
    private int releaseDate;
}
