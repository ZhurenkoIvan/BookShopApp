package com.example.BookShopApp.data;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> books;
}
