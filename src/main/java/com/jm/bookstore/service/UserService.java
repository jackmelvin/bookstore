package com.jm.bookstore.service;

import com.jm.bookstore.model.User;
import com.jm.bookstore.model.security.PasswordResetToken;
import com.jm.bookstore.model.security.UserRole;

import java.util.Set;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
