package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.email.EmailService;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.EmailData;
import com.bridgelabz.bookstoreapp.model.UserData;
import com.bridgelabz.bookstoreapp.services.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    EmailService emailService;

    @Autowired
    private IUserInterface userService;

    @RequestMapping(value={"", "/", "get"})
    public String getBooksAvailable(){
        return "Get Call for User Succesfull";
    }

    @PostMapping("/login/")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        UserData userData = null;
        userData = userService.createUserProfile(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("login Successfull with ", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    getting email after sign up
    @PostMapping("/signup/")
    public ResponseEntity signIn(@RequestBody EmailData emailData) {
//        EmailData emailData = null;
        emailService.sendEmail(emailData.getToEmail(), emailData.getSubject(), emailData.getBody());
//        ResponseDTO responseDTO = new ResponseDTO("U have sign in ", emailData);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/gettoken/")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        ResponseDTO responseDTO = userService.loginValidation(loginDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addincart/{bookName}")
    public ResponseEntity<ResponseDTO> addBookInCart(@RequestBody BookDTO bookDTO) {
        BookData bookData = null;
        bookData = userService.addBookInCart(bookData);
        ResponseDTO responseDTO = new ResponseDTO("book added in cart ", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addinwishlist/{bookName}")
    public String addBookInWishList(@PathVariable String bookName) {
        return "Add Book In WishiList Call for Customer Successful with Book Name " + bookName;
    }
}
