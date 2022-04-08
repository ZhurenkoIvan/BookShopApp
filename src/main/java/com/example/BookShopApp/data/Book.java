package com.example.BookShopApp.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "priceOld")
    private String priceOld;
    @Column(name = "price")
    private String price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

}
