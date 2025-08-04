package authproject.secure_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authproject.secure_backend.entity.User;
import authproject.secure_backend.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth/test")
public class AuthController {

	
	@Autowired
	private UserService service;
	
	@GetMapping("/all")
	public String allAccess() {
		return "you should be able to see this no matter who you are.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
	    return "User Content.";
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return service.verify(user);
	}
}
