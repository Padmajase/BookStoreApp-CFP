package com.bridgelabz.bookstoreapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @RequestMapping(value={"", "/", "get"})
    public String getBooksAvailable(){
        return "Get Call for Seller Succesfull";
    }

    @PostMapping("/addbookinstore/")
    public String addBookIncart(@RequestParam("bookName") String bookName) {
        return "Add Book Call of Seller Successful with Book Name " + bookName;
    }


}
