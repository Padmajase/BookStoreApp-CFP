package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.services.IBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
adding book for approval from admin
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    /*************** injecting book interface object here ***************/
    @Autowired
    private IBookInterface bookInterface;


    /*************** adding book to book store ***************/
    @PostMapping("/addbookinstore/")
    public ResponseEntity<ResponseDTO> addBookInStore(@RequestBody BookDTO bookDTO) {
        BookData bookData = null;
        bookData = bookInterface.approveBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Added With Details : ", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
