package authproject.secure_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authproject.secure_backend.entity.User;
import authproject.secure_backend.service.JWTService;
import authproject.secure_backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth/test")
public class AuthController {

	
	@Autowired
	private UserService service;
	
	@Autowired
	private JWTService jwtService;
	
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
	public String register(@RequestBody User user) {
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return service.verify(user);
	}
	
	@GetMapping("/resource")
	public String message(HttpServletRequest request) {
		String authheaderString = request.getHeader("Authorization").substring(7);
		return jwtService.extractUserName(authheaderString);
	}
}
