package com.car.systems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.car.systems.models.User;
import com.car.systems.services.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user;
		List<GrantedAuthority> authorities = new ArrayList<>();
		try {
			user = userService.login(name, password);
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
		} catch (Exception e) {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
			auth.setAuthenticated(false);
			return auth;
		}

		return new UsernamePasswordAuthenticationToken(name, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
