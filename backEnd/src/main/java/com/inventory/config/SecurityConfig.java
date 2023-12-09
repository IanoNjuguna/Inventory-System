package com.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.anyRequest().permitAll())
			.formLogin((formLogin) ->
	            formLogin.loginPage("/login").permitAll()          
	            		 .usernameParameter("email")
				         .passwordParameter("password")				         
				         .failureUrl("/authentication/login?failed")
				         .loginProcessingUrl("/authentication/login/process"))
			.logout((logout) ->
					logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						  .deleteCookies("JSESSIONID")
						  .logoutSuccessUrl("/login"));
//			.rememberMe(Customizer.withDefaults());
						
		return http.build();			
	}
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

}
