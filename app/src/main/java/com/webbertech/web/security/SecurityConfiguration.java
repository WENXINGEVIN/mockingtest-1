package com.webbertech.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.httpBasic().
      and().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/", "/index").permitAll() 
        .antMatchers(HttpMethod.POST, "/employee/**").permitAll()
        .antMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/logout").authenticated()
        .and().formLogin()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied")
        .and().csrf().disable();
  
    }
}
