package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.email.EmailService;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.OrderData;
import com.bridgelabz.bookstoreapp.services.ICartService;
import com.bridgelabz.bookstoreapp.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*************** getting cart list and placing order for books in cart ***************/
@RestController
@RequestMapping("/cart")
public class CartController {

    /*************** injecting Cart Interface Object ***************/
    @Autowired
    private ICartService cartService;

    /*************** injecting order interface object here ***************/
    @Autowired
    private IOrderService orderService;

    /*************** injecting Email Interface Object ***************/
    @Autowired
    private EmailService emailService;

    /*************** getting book list in cart ***************/
    @RequestMapping(value={"", "/", "get"})
    public ResponseEntity<ResponseDTO> getCartList(){
        List<BookData> bookListInCart = null;
        bookListInCart = cartService.getBookListInCart();
        ResponseDTO responseDTO = new ResponseDTO("Your Cart :",bookListInCart);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /*************** placing order for books in cart ***************/
    @PostMapping("/placeorder")
    public ResponseEntity<ResponseDTO> placeOrder(@RequestHeader(name = "token") String token,
                                                  @RequestBody OrderDTO orderDTO,
                                                  @RequestParam int bookId) {
        OrderData orderData = orderService.createOrderData(token, orderDTO, bookId);
        ResponseDTO responseDTO = new ResponseDTO("Order placed", orderData);
        emailService.sendEmail(orderData.getUserData().getEmailId(), "Order Placed Successfully.",
                "Dear " + orderData.getUserData().getFirstName()
                        + ", Your order has placed for Book : "
                        + orderData.getBookData().getBookName());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}


