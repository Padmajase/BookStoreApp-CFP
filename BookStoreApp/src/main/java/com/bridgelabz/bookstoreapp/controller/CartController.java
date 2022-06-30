package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    @RequestMapping(value={"", "/", "get"})
    public ResponseEntity<ResponseDTO> getCartList(){
        List<BookData> bookListInCart = null;
        bookListInCart = cartService.getBookListInCart();
        ResponseDTO responseDTO = new ResponseDTO("Your Cart :",bookListInCart);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}


