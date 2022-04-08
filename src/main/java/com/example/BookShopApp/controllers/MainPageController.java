package com.example.BookShopApp.controllers;

import com.example.BookShopApp.service.BookshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    @Autowired
    private BookshopService bookshopService;


    @GetMapping("/main")
    public String mainPage(Model model) {

        model.addAttribute("bookAndAuthorData", bookshopService.getAllBooksAndAuthors());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "/genres/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model){

        model.addAttribute("authorData", bookshopService.getAllAuthors());
        return "/authors/index";
    }
}
