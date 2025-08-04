package authproject.secure_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import authproject.secure_backend.entity.User;
import authproject.secure_backend.entity.UserPrincipal;
import authproject.secure_backend.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user1 = repository.findByUsername(username);
		
		if (user1 == null) {
			throw new UsernameNotFoundException("user not found of name: " + username);
		}
		
		return new UserPrincipal(user1);
	}
}
