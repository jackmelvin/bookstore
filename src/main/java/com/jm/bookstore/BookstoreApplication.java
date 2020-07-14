package com.jm.bookstore;

import com.jm.bookstore.model.User;
import com.jm.bookstore.model.security.Role;
import com.jm.bookstore.model.security.UserRole;
import com.jm.bookstore.service.UserService;
import com.jm.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("j");
		user1.setLastName("m");
		user1.setUsername("jm");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("jm"));
		user1.setEmail("boylaixa@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

	}
}
