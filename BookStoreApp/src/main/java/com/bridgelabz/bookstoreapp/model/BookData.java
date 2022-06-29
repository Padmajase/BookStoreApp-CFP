package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BookData {

    @Id
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private long bookPrice;

    public BookData(int bookId, BookDTO bookDTO) {
        this.bookId=bookId;
        this.bookName=bookDTO.bookName;
        this.bookAuthor=bookDTO.bookAuthor;
        this.bookPrice=bookDTO.bookPrice;
    }

    public BookData() {

    }

    public String getBookName() {
        return bookName;
    }
}
