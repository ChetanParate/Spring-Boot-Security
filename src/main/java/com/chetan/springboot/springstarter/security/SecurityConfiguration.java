package com.chetan.springboot.springstarter.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*		for inlineMemory
 * //auth.inMemoryAuthentication().withUser("chetan").password("success").roles("USER")
		//.and().withUser("admin").password("admin").roles("ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource);
		.withDefaultSchema()
		.withUser("chetan").password("success").roles("USER")
		.and().withUser("admin").password("admin").roles("ADMIN");
*/	
		//For default select
		//auth.jdbcAuthentication().dataSource(dataSource);
		
		//for custom tables
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance(); 
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user","/topic").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	
	
	

}
