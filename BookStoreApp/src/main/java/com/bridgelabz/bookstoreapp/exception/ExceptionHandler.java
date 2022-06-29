package com.bridgelabz.bookstoreapp.exception;

import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private static final String message = "Exception While Processing REST Request";

    @org.springframework.web.bind.annotation.ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<ResponseDTO> handleUserRegistrationException(UserRegistrationException exception) {
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

}
