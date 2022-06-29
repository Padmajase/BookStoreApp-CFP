package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.CartData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<BookData, Integer> {
}
