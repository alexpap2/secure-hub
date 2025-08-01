package authproject.secure_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import authproject.secure_backend.security.request.LoginRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/babis/test")
public class AuthController {

	
	@GetMapping("/all")
	public String allAccess() {
		return "you should be able to see this no matter who you are.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
	    return "User Content.";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		
		if ("user".equals(request.getUsername()) && "password".equals(request.getPassword()) ) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		
	}
}
