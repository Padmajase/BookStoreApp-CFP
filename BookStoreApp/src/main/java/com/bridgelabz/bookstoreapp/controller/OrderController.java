package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.email.EmailService;
import com.bridgelabz.bookstoreapp.email.IEmailService;
import com.bridgelabz.bookstoreapp.model.OrderData;
import com.bridgelabz.bookstoreapp.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @Autowired
    EmailService emailService;

    @RequestMapping(value={"", "/", "get"})
    public String getBooksAvailable(){
        return "Get Call for Order Controller Succesfull";
    }

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
        return  new ResponseEntity<ResponseDTO> (responseDTO, HttpStatus.OK);
    }

}
