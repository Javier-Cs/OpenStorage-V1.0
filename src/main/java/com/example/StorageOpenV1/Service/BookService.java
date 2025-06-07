package com.example.StorageOpenV1.Service;

import com.example.StorageOpenV1.Entity.BookEntity;

import java.util.List;
import java.util.Optional;


public interface BookService {

    BookEntity saveBook(BookEntity book);
    BookEntity updateBook(BookEntity book);
    List<BookEntity> getAllBooks();
    Optional<BookEntity> getBookById(long id);
    boolean deleteBookById(long id);


}
