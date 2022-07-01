package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.UserData;
import com.bridgelabz.bookstoreapp.services.IBookInterface;
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
@RequestMapping("/admin")
public class AdminController {

    /*************** injecting Book Interface Object ***************/
    @Autowired
    private IBookInterface bookService;

    /*************** injecting User Interface Object ***************/
    @Autowired
    private IUserInterface userService;

    /*************** getting registered user list ***************/
    @RequestMapping("/userList/")
    public ResponseEntity<ResponseDTO> getUserList(){
        List<UserData> listOfUser = null;
        listOfUser = userService.getUserList();
        ResponseDTO responseDTO = new ResponseDTO("User List :",listOfUser);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*************** deleting user by their user ID ***************/
    @PutMapping("/deleteuser/{userId}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable int userId){
        userService.deleteUserData(userId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +userId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /*************** getting book list ***************/
    @RequestMapping("/bookList/")
    public ResponseEntity<ResponseDTO> getBookList(){
        List<BookData> listOfBook = null;
        listOfBook = bookService.getBookList();
        ResponseDTO responseDTO = new ResponseDTO("Books Available :",listOfBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*************** delete book by its Id ***************/
    @PostMapping("/deletebook/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable int bookId){
        bookService.deleteBookData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Book Deleted Successfully", "with book Id : " +bookId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /*************** update book by ID ***************/
    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookData(@PathVariable("bookId") int bookId,
                                                      @RequestBody BookDTO bookDTO){
        bookService.updateBookById(bookId, bookDTO);
        ResponseDTO respDTO = new ResponseDTO("Book Data Updated Successfully", "with book Id : " +bookId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    /*************** approve/add book in book repository ***************/
    @PostMapping("/approvebook/")
    public ResponseEntity<ResponseDTO> addBookInStore(@RequestBody BookDTO bookDTO) {
        BookData bookData = null;
        bookData = bookService.approveBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Added With Details : ", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
