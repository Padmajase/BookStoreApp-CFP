package com.bridgelabz.bookstoreapp.services;


import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.UserData;

import java.util.List;

public interface IUserInterface {
    UserData createUserProfile(UserDTO userDTO);

    List<UserData> getUserList();

    ResponseDTO loginValidation(LoginDTO loginDTO);

    void deleteUserData(int userId);

    BookData addBookInCart(BookData bookData);
}
