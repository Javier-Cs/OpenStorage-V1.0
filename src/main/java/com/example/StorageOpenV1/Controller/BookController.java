package com.example.StorageOpenV1.Controller;

import com.example.StorageOpenV1.Entity.BookEntity;
import com.example.StorageOpenV1.Service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/BookWeb/v1")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/GetAllBooks")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> books = bookServiceImpl.getAllBooks();
        if( books== null || books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/GetOneBookId/{id}")
    public ResponseEntity<Optional<BookEntity>> getBookById(@PathVariable("id") long id) {
        Optional<BookEntity> book = bookServiceImpl.getBookById(id);
        if(book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/SaveBook")
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity book) {
        try{
            BookEntity bookEntity = bookServiceImpl.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookEntity);
        }catch (Exception e) {
            System.out.println("---------------------"+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping()
    public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity book) {
        try{
            BookEntity saveBook = bookServiceImpl.updateBook(book);
            return ResponseEntity.status(HttpStatus.OK).body(saveBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/DeleteBookId/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") long id) {
        try{
            boolean result = bookServiceImpl.deleteBookById(id);
            if(result) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
