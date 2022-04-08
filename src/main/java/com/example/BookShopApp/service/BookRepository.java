package com.example.BookShopApp.service;

import com.example.BookShopApp.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
