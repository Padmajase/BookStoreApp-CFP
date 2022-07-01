package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.model.BookData;

import java.util.List;

public interface ICartService {
    List<BookData> getBookListInCart();

    BookData addBookInCart(BookDTO bookDTO);

}
