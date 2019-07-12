package com.example.demo;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class SpringJdbcUserDetailsManager extends JdbcUserDetailsManager {
	@Override
	protected void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
		super.addCustomAuthorities(username, authorities);
		authorities.add(new SimpleGrantedAuthority("Payment"));
	}
}
