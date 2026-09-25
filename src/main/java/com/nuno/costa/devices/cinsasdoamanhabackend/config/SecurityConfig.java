package com.nuno.costa.devices.cinsasdoamanhabackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors(Customizer.withDefaults())
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers(HttpMethod.GET, "/api/scores/**").permitAll() // Público para ler o top
				.anyRequest().authenticated() // Exige token JWT para o /api/saveScore
			)
			.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())); // Valida o JWT do Supabase

		return http.build();
	}
}
