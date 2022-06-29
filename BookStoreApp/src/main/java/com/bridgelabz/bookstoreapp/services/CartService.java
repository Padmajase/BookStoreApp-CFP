package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private CartRepository cartRepository;
    @Override
    public List<BookData> getBookListInCart() {
        return cartRepository.findAll();
    }
}
