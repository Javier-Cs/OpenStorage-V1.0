package com.example.StorageOpenV1.Service;

import com.example.StorageOpenV1.Entity.BookEntity;
import com.example.StorageOpenV1.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public BookEntity updateBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<BookEntity> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean deleteBookById(long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
