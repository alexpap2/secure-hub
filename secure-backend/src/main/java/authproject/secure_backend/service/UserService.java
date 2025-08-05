package authproject.secure_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import authproject.secure_backend.entity.User;
import authproject.secure_backend.repository.UserRepository;

@Service
public class UserService {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	public String register(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		return jwtService.getToken(user.getUsername());
	}
	
	public String verify(User user) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(
						user.getUsername(), user.getPassword()));
		
		if (authentication.isAuthenticated()) {
			return jwtService.getToken(user.getUsername());
		}
		
		return "fail";
	}
}
