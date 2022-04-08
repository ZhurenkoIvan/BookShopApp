package com.example.BookShopApp.service;

import com.example.BookShopApp.data.Author;
import com.example.BookShopApp.data.Book;
import com.example.BookShopApp.dto.BookAndAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookshopService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ArrayList<>(books);
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return new ArrayList<>(authors);
    }

    public List<BookAndAuthor> getAllBooksAndAuthors() {

        Query query = entityManager.createQuery("SELECT Book.title, Book.price, Book.priceOld, Author.name FROM Book JOIN Author ON Book.author");
        List booksAndAuthors = query.getResultList();
//        List<BookAndAuthor> booksAndAuthors = new ArrayList<>();
//        List<Book> books = getAllBooks();
//        List<Author> authors = getAllAuthors();
//        books.forEach(book -> {
//            BookAndAuthor bookAndAuthor = new BookAndAuthor();
//            authors.forEach(a -> {
//                if (a == book.getAuthor()) {
//                    bookAndAuthor.setAuthor(a.getName());
//                    bookAndAuthor.setPrice(book.getPrice());
//                    bookAndAuthor.setTitle(book.getTitle());
//                    bookAndAuthor.setPriceOld(book.getPriceOld());
//                    booksAndAuthors.add(bookAndAuthor);
//                }
//            });
//        });
        return booksAndAuthors;
    }


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
