package com.student;

import com.student.entities.Account;
//import com.student.entities.Post;
import com.student.repositories.AccountRepository;
//import com.student.repositories.PostRepository;
import com.student.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner{

	@Autowired
	private AccountRepository accountRepository;
//	@Autowired
//	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		// BUILDER PATTERN: using builder pattern to create an account
		Account account = new Account.AccountBuilder().setName(null).setGender(null).setDateOfBirth(null).setEmail(null).setPassword(null).build();

	}
}


