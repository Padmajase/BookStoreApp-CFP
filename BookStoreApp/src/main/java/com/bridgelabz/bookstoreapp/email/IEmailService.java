package com.bridgelabz.bookstoreapp.email;

import com.bridgelabz.bookstoreapp.dto.EmailDTO;
import com.bridgelabz.bookstoreapp.model.EmailData;

public interface IEmailService {
//    EmailData sendEmail(EmailDTO emailDTO);

    void sendEmail(String toEmail, String subject, String body);
}
