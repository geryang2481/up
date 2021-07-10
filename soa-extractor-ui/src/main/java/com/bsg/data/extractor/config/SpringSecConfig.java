package com.bsg.data.extractor.config;

import org.springframework.core.env.Environment;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.util.StringUtils;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
     private Environment env;
	 
     private static final String SALT[] = new String[] { "oCiRvFKV780n6dBDsZvWGpjh1A9lZxOeczZQWtd3TBtwrJr+jwIyPe6qMaTLZjritihEeNwmTeSmjtfcAPvIe0M8GfsgtzQNqGpcQQJ4mIU=", "" }; // Salt should be protected carefully
     private static final String VALUE = "abOSOo0ryNNYz5VAj/ErnEqtNHKKb7zQoQwuAw/5T3xg3iQvERqotM1Z2peih0guG8JikVtYFoFTwZ3if2LKcyEgtyxXHY0jvQ8pwwFb9+A=";
     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
    	 return new BCryptPasswordEncoder(12, new SecureRandom(StringUtils.join(SALT, VALUE).getBytes()));
     }
     
     
	 private static final String[] PUBLIC_MATCHERS = {
             "/about/**",
             "/console/**",
             "/contact/**",
             "/create/**",
             "/css/**", 
             "/delete/**",
             "/download/**",
             "/error/**/*",
             "/extract/**",
             "/files/**",
             "/static/**",
             "/images/**",
             "/fragments/**",
             "/js/**",
             "/load/**",
             "/save/**",
             "/devops",
             "/disconnect",
             "/system-exit",
             "/login",
             "/dataExtractor",
             "/upload/**",
             "/verify/**",
             "/webjars/**",
             "/"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        		//HTTP Basic authentication
		        .httpBasic()
		        //.and()
		        //.authenticationEntryPoint(restAuthenticationEntryPoint)
		        .and()
                .authorizeRequests().
//                antMatchers("/**").
                antMatchers(PUBLIC_MATCHERS).
                permitAll().anyRequest().authenticated();

        http
                .csrf().disable().cors().disable()
                .formLogin().failureUrl("/index?error")
                .defaultSuccessUrl("/home").loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	env.toString();
    	auth.inMemoryAuthentication().withUser("a").password(passwordEncoder().encode("a")).roles("ADMIN"); //This is in-memory authentication
    	auth.inMemoryAuthentication().withUser("u").password(passwordEncoder().encode("u")).roles("USER"); //This is in-memory authentication
    }
}
