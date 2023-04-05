package com.paintcolour.springassessment.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userAuth() {
		UserDetails user1 = User.builder()
				.username("manager1")
				.password(encoder().encode("mngr1Pass"))
				.roles("MANAGERS", "USERS")
				.build();

		UserDetails user2 = User.builder()
				.username("user1")
				.password(encoder().encode("usr1Pass"))
				.roles("USERS")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
				.cors().and()
				.authorizeHttpRequests((authz) -> authz
						.antMatchers(HttpMethod.GET,"/colors/**").permitAll()
						.antMatchers(HttpMethod.POST, "/colors/**").hasRole("MANAGERS")
						.antMatchers(HttpMethod.PUT,"/colors/**").hasRole("MANAGERS")
						.antMatchers(HttpMethod.DELETE,"/colors/**").hasRole("MANAGERS")
						.antMatchers(HttpMethod.GET,"/colors","/colors/mix").hasAnyRole("USERS","MANAGERS")
						.anyRequest().authenticated()
				)
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}
