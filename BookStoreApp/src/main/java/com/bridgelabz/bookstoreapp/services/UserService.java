package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.BookDTO;
import com.bridgelabz.bookstoreapp.dto.LoginDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.dto.UserDTO;
import com.bridgelabz.bookstoreapp.exception.UserRegistrationException;
import com.bridgelabz.bookstoreapp.model.BookData;
import com.bridgelabz.bookstoreapp.model.UserData;
import com.bridgelabz.bookstoreapp.repository.CartRepository;
import com.bridgelabz.bookstoreapp.repository.UserRepository;
import com.bridgelabz.bookstoreapp.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserInterface{

    /*************** injecting User repository object here ***************/
    @Autowired
    private UserRepository userRepository;

    /*************** injecting Cart repository object here ***************/
    @Autowired
    private CartRepository cartRepository;

    /*************** injecting Token object here ***************/
    @Autowired
    private TokenUtil tokenUtil;

    /*************** adding user details to user repository ***************/
    @Override
    public UserData createUserProfile(UserDTO userDTO) {
        UserData userData = new UserData(userRepository.findAll().size() + 1, userDTO);
        userRepository.save(userData);
        return userData;
    }

    /*************** getting user list from user repository ***************/
    @Override
    public List<UserData> getUserList() {
        return userRepository.findAll();
    }

    /*************** validating user by token ***************/
    @Override
    public ResponseDTO loginValidation(LoginDTO loginDTO) {
        String token;
        Optional<UserData> isUserPresent = userRepository.findByEmailId(loginDTO.getEmailId());

        if (isUserPresent.isPresent()) {
            String password = isUserPresent.get().getPassword();
            if (password.equals(loginDTO.getPassword())) {
                token = tokenUtil.createToken(isUserPresent.get().getUserId());
                return new ResponseDTO("User is Found", token);
            } else throw new UserRegistrationException("Password is Wrong");
        }
        else {
            throw new UserRegistrationException("Email Id or Password is Wrong");
        }
    }

    /*************** deleting user from user repository ***************/
    @Override
    public void deleteUserData(int userId) {
        userRepository.deleteById(userId);
    }
}
