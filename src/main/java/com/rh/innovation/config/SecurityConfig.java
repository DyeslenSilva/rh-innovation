package com.rh.innovation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity httpSecurity,
			String admin,String loginUrl,String successLoginUrl,
			String failLoginUrl,String logoutUrl,String cookies) throws Exception{
				httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/gestorRH/**").hasRole(admin)
			.antMatchers("/anonymous/").anonymous()
			.antMatchers("/login/*").permitAll()
			.anyRequest().authenticated().and().formLogin()
			.loginPage("/login.html").loginProcessingUrl(loginUrl)
			.defaultSuccessUrl(successLoginUrl).failureUrl(failLoginUrl)
			.failureHandler(authenticationFailureHandler()).and().logout()
			.logoutUrl(logoutUrl).deleteCookies(cookies).logoutSuccessHandler(logoutSuccessHandler());
	}
	
	private LogoutSuccessHandler logoutSuccessHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private AuthenticationFailureHandler authenticationFailureHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public void configure(AuthenticationManagerBuilder managerBuilder
			,String usuario1, String senha1,
			String usuario2, String senha2,
			String usuario3, String senha3) throws Exception {
				managerBuilder.inMemoryAuthentication().withUser(usuario1)
			.password(passwordEncoder().encode(senha1)).roles(usuario1)
			.and()
			.withUser(usuario2).password(passwordEncoder().encode(senha2)).roles(usuario2)
			.and()
			.withUser(usuario3).password(passwordEncoder().encode(senha3)).roles(usuario3);
	}

	@Bean
	private PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
}
