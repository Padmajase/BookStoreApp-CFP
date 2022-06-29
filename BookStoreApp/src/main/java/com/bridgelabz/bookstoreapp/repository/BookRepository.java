package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.BookData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookData, Integer> {
    Optional<BookData> findByBookId(int bookId);
}
