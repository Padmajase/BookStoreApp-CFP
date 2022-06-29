package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.UserData;

import java.util.List;

public interface IBookInterface {
    BookData approveBook(BookDTO bookDTO);

    List<BookData> getBookList();
}
