package com.chetan.springboot.springstarter.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	/*//MySQL auth
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//for custom tables
		auth.userDetailsService(userDetailsService);
	}*/
	
	/*//LDAP login
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.ldapAuthentication()
		.userDnPatterns("uid={0},ou=people").groupSearchBase("ou=groups");

	}*/
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		for inlineMemory
  //auth.inMemoryAuthentication().withUser("chetan").password("success").roles("USER")
		//.and().withUser("admin").password("admin").roles("ADMIN");
		 * }
		 */
/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/* With default schema and data 
		auth.jdbcAuthentication()
		.dataSource(dataSource);
		.withDefaultSchema()
		.withUser("chetan")
		.password("success")
		.roles("USER")
		.and().
		withUser("admin")
		.password("admin")
		.roles("ADMIN");
			}
			*/
/*	@Override
 * protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//For default select
		//auth.jdbcAuthentication().dataSource(dataSource);
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
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
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
	}
	*/
	
	

}
