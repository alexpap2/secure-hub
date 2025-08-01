package authproject.secure_backend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/test")
public class TestController {

	
	@GetMapping("/all")
	public String allAccess() {
		return "you should be able to see this no matter who you are.";
	}
	 @GetMapping("/user")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  public String userAccess() {
	    return "User Content.";
	  }
}
