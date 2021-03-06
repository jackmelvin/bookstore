package com.jm.bookstore.utility;

import com.jm.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    public SimpleMailMessage constructResetTokenEmail (
            String contextPath, Locale locale, String token, User user, String password) {

        String url = contextPath + "/newAccount?token=" + token;
        String message = "\nPlease lick on this link to verify your email and edit your personal information. Your password is: \n" + password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("JM's Bookstore - New User");
        email.setText(url + message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
