package com.example.BookShopApp.service;

import com.example.BookShopApp.data.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
