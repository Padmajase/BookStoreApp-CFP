package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.services.IBookInterface;
import com.bridgelabz.bookstoreapp.services.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IBookInterface bookService;

    @Autowired
    private IUserInterface userService;

    @RequestMapping(value={"", "/", "getorderlist"})
    public String getBooksAvailable(){
        return "Get Call for Admin Succesfull";
    }

    @PostMapping("/approvebook/")
    public ResponseEntity<ResponseDTO> addBookInCart(@RequestBody BookDTO bookDTO) {
        BookData bookData = null;
        bookData = bookService.approveBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Book Added With Details : ", bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/deleteuser/{userId}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable int userId){
        userService.deleteUserData(userId);
            ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +userId);
            return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }



    @PostMapping("/deletebook/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookById(@PathVariable int bookId){
        bookService.deleteBookData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Book Deleted Successfully", "with book Id : " +bookId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

//    @PutMapping("/update/{bookId}")
//    public ResponseEntity<ResponseDTO> updateBookData(@PathVariable("empId") int bookId,
//                                                      @RequestBody BookDTO bookDTO){
//        bookService.updateBookById(bookId, bookDTO);
//        ResponseDTO respDTO = new ResponseDTO("Book Data Updated Successfully", "with book Id : " +bookId);
//        return new ResponseEntity<>(respDTO, HttpStatus.OK);
//    }

}
