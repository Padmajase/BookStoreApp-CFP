package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.OrderData;
import com.bridgelabz.bookstoreapp.model.UserData;
import com.bridgelabz.bookstoreapp.repository.BookRepository;
import com.bridgelabz.bookstoreapp.repository.OrderRepository;
import com.bridgelabz.bookstoreapp.repository.UserRepository;
import com.bridgelabz.bookstoreapp.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    /*************** injecting TokenUtil Object ***************/
    @Autowired
    private TokenUtil tokenUtil;

    /*************** injecting User Repository Object ***************/
    @Autowired
    private UserRepository userRepository;

    /*************** injecting Book Repository Object ***************/
    @Autowired
    private BookRepository bookRepository;

    /*************** injecting Order Repository Object ***************/
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public OrderData createOrderData(String token, OrderDTO orderDTO, int bookId) {
        int userId = tokenUtil.decodeToken(token);
        Optional<UserData> user = userRepository.findById(userId);
        Optional<BookData> book = bookRepository.findByBookId(bookId);
        OrderData orderData = new OrderData();
        if (user.isPresent() && book.isPresent()) {
            orderData.setUserData(user.get());
            orderData.setBookDetails(book.get());
            orderData.createOrder(orderDTO);
            return orderRepository.save(orderData);
        } else throw new UserRegistrationException("User Id or Book Id is Invalid");

    }

    @Override
    public OrderData cancelOrder(String token, int orderId) {
        return null;
    }

    @Override
    public List<OrderData> getAllOrdersOfUser(String token) {
        return null;
    }

    @Override
    public List<OrderData> findAllOrders() {
        return null;
    }
}
