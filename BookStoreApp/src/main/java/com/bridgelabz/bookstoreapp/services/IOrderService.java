package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.OrderDTO;
import com.bridgelabz.bookstoreapp.model.OrderData;

import java.util.List;

public interface IOrderService {
    OrderData createOrderData(String token, OrderDTO orderDTO, int bookId);

    OrderData cancelOrder(String token, int orderId);

    List<OrderData> getAllOrdersOfUser(String token);

    List<OrderData> findAllOrders();}
