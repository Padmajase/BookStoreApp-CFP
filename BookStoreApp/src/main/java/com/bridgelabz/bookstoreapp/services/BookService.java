package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookInterface{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookData approveBook(BookDTO bookDTO) {
        BookData bookData = new BookData(bookRepository.findAll().size() + 1, bookDTO);
        bookRepository.save(bookData);
        return bookData;
    }

    @Override
    public List<BookData> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookData(int bookId) {
        bookRepository.deleteById(bookId);
    }

//    @Override
//    public void updateBookById(int bookId, BookDTO bookDTO) {
//        List<BookData> bookDataList = this.getBookList();
//        for (BookData bookData : bookDataList) {
//            if(bookData.getBookId() == bookId) {
//                bookData.setBookName(bookDTO.bookName);
//                bookData.set(employeePayrollDTO.salary);
//                employeePayrollRepository.save(empData);
//                return empData;
//            }
//        }
//        return null;
//    }
}
