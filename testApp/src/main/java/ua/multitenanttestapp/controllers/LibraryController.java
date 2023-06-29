package ua.multitenanttestapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.multitenanttestapp.models.Book;
import ua.multitenanttestapp.service.BookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/library")
public class LibraryController {

    private final BookService bookService;

    @GetMapping("/allBooks")
    public List<Book> outputAllBooks() {
        return bookService.findAll();
    }
}

