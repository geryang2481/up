package com.bluesprucegroup.njrealtors.csvtopdf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.WebServiceCryptoUtil;
import com.bluesprucegroup.njrealtors.csvtopdf.service.impl.UserSecurityServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private UserSecurityServiceImpl userSecurityService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final String SALT = "";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return WebServiceCryptoUtil.passwordEncoder();//new BCryptPasswordEncoder(12, new SecureRandom(StringUtils.join(SALT, WebServiceCryptoUtil.getSalt()).getBytes()));
    }

    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**", 
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**",
            "/signup",
            "/files/**",
            "/load/**",
            "/upload/**",
            "/create/**",
            "/save/**",
            "/download/**",
            "/delete/**",
            "/verify/**",
            "/extract/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().
                //antMatchers("/**").
                antMatchers(PUBLIC_MATCHERS).
                permitAll().anyRequest().authenticated();

        http
                .csrf().disable().cors().disable()
                .formLogin().failureUrl("/index?error").defaultSuccessUrl("/userFront").loginPage("/index").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe(); 
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	env.toString();//auth.user
    	auth.inMemoryAuthentication().withUser("a").password(passwordEncoder.encode("a")).roles("ADMIN"); //This is in-memory authentication
    	auth.inMemoryAuthentication().withUser("realtor").password(passwordEncoder.encode("agent")).roles("ADMIN"); //This is in-memory authentication
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }


}
