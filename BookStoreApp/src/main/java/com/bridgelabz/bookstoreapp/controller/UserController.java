package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.email.EmailService;
import com.bridgelabz.bookstoreapp.model.EmailData;
import com.bridgelabz.bookstoreapp.model.UserData;
import com.bridgelabz.bookstoreapp.services.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*
adding user login,
sending email,
getting token
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /*************** injecting Email service Object ***************/
    @Autowired
    EmailService emailService;

    /*************** injecting User Interface Object ***************/
    @Autowired
    private IUserInterface userService;

    /*************** logging for user ***************/
    @PostMapping("/login/")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        UserData userData = null;
        userData = userService.createUserProfile(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("login Successfull with ", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*************** getting email after sign up ***************/
    @PostMapping("/signup/")
    public ResponseEntity signIn(@RequestBody EmailData emailData) {
        emailService.sendEmail(emailData.getToEmail(), emailData.getSubject(), emailData.getBody());
        return ResponseEntity.ok("success");
    }

    /*************** getting token here by user emailId and password ***************/
    @PostMapping("/gettoken/")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        ResponseDTO responseDTO = userService.loginValidation(loginDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
