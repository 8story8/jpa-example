package jpa.example.service;

import org.springframework.stereotype.Service;

import jpa.example.model.User;
import jpa.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public User registerUser(String name) {
		final User user = User.builder().name(name).build();
		return userRepository.save(user);
	}

}
