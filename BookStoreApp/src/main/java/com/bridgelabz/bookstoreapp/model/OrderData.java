package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderData {

    @Id
    private int orderId;
    private int price;
    private int quantity;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    private String address;

//    private List<BookService> bookList;
    @ManyToOne
    @JoinColumn(name = "user_ID", referencedColumnName = "UserId")
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "book_ID", referencedColumnName = "BookId")
    private BookData bookData;

    private boolean cancel = false;

    public void createOrder(OrderDTO orderDTO){
        this.address = orderDTO.getAddress();
        this.orderDate = LocalDate.now();
        this.price = orderDTO.getPrice();
        this.quantity = orderDTO.getQuantity();
        this.cancel = false;
    }

    public void setBookDetails(BookData bookData) {
        this.bookData = bookData;
    }

    public Object getBookDetails() {
        return bookData;
    }
}
