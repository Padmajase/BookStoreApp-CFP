package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.services.IBookInterface;
import com.bridgelabz.bookstoreapp.services.ICartService;
import com.bridgelabz.bookstoreapp.services.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
giving permission for
accessing user list, book list in book store,
deleting user,book
update book details
approve/add book
 */
@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    /*************** injecting Book Interface Object ***************/
    @Autowired
    private IBookInterface bookInterface;

    /*************** injecting Cart Interface Object ***************/
    @Autowired
    private ICartService cartInterface;

    /*************** getting book list in book store ***************/
    @RequestMapping("/bookList/")
    public ResponseEntity<ResponseDTO> getBookList(){
        List<BookData> listOfBook = null;
        listOfBook = bookInterface.getBookList();
        ResponseDTO responseDTO = new ResponseDTO("Books Available :",listOfBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*************** adding book in cart ***************/
    @PostMapping("/addincart/")
    public ResponseEntity<ResponseDTO> addBookInCart(@RequestBody BookDTO bookDTO) {
        BookData bookData = null;
        bookData = cartInterface.addBookInCart(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("book added in cart ", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*************** adding book in wishlist ***************/
    @PostMapping("/addinwishlist/")
    public String addBookInWishList(@PathVariable String bookName) {
        return "Add Book In WishiList Call for Customer Successful with Book Name " + bookName;
    }

}
