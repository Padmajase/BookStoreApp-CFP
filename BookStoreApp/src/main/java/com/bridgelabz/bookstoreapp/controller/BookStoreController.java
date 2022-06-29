package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.UserData;
import com.bridgelabz.bookstoreapp.services.IBookInterface;
import com.bridgelabz.bookstoreapp.services.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    @Autowired
    IUserInterface userInterface;

    @Autowired
    IBookInterface bookInterface;

    @RequestMapping(value={"", "/", "get"})
    public String getBooksList(){
        return "Get Call Successful for BookStore Book List";
    }

    @RequestMapping("/userList/")
    public ResponseEntity<ResponseDTO> getUserList(){
        List<UserData> listOfUser = null;
        listOfUser = userInterface.getUserList();
        ResponseDTO responseDTO = new ResponseDTO("User List :",listOfUser);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/bookList/")
    public ResponseEntity<ResponseDTO> getBookList(){
        List<BookData> listOfBook = null;
        listOfBook = bookInterface.getBookList();
        ResponseDTO responseDTO = new ResponseDTO("Books Available :",listOfBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
