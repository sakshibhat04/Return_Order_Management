package com.roms.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.roms.authentication.entity.User;
import com.roms.authentication.repository.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AuthenticationServiceApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("nikhil", passwordEncoder.encode("bhat"), "ROLE_USER"));
		userRepository.save(new User("neha", passwordEncoder.encode("bhat"), "ROLE_USER"));
		userRepository.save(new User("sakshi", passwordEncoder.encode("bhat"), "ROLE_USER"));
		userRepository.save(new User("shweta", passwordEncoder.encode("bhat"), "ROLE_USER"));
	}
}
