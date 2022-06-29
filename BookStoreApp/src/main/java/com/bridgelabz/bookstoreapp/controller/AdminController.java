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

    @PutMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable int userId){
        userService.deleteUserData(userId);
            ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " +userId);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }



    @PostMapping("/orderbook/")
    public  String orderBookToSeller(@PathVariable("bookName") String bookName){
        return "Post Call SuccessFull for admin with book  name " + bookName;
    }

    @PutMapping("/update/{bookId}")
    public String updateBookStatus(@PathVariable int bookId){
        return "Updated Book Status With Book Id "+bookId;
    }

}
