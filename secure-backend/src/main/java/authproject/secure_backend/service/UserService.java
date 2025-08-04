package authproject.secure_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import authproject.secure_backend.entity.User;
import authproject.secure_backend.repository.UserRepository;

@Service
public class UserService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@Autowired
	private UserRepository repository;
	
	public User register(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return repository.save(user);
	}
}
