package com.example.StorageOpenV1.Repository;

import com.example.StorageOpenV1.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
