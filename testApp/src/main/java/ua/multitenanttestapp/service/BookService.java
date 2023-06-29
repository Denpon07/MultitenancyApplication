package ua.multitenanttestapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.multitenanttestapp.models.Book;
import ua.multitenanttestapp.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
