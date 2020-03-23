package it.lucci.demo.loginapp.security;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.lucci.demo.loginapp.dao.CredentialDAO;
import it.lucci.demo.loginapp.entity.Credential;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	private CredentialDAO credentialDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Credential credential = null;
		try {
			credential = credentialDAO.loadCredentialByUsername(username);
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Login failed for user [{}]", username);
			throw new UsernameNotFoundException("Credentials not found");
		}
		
		if (credential == null) {
			LOGGER.info("Login failed for user [{}]", username);
			throw new UsernameNotFoundException("Credentials not found");
		}
			
		LOGGER.info("Login success for user [{}]", username);
		return new User(credential.getUsername(), credential.getPassword(),
					Arrays.asList(new SimpleGrantedAuthority(credential.getRole())));
		
	}


}
