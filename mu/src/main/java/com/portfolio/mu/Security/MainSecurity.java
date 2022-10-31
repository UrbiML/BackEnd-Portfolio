package com.portfolio.mu.Security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.portfolio.mu.Security.Service.UserDetailsServiceImpl;
import com.portfolio.mu.Security.jwt.JwtEntryPoint;
import com.portfolio.mu.Security.jwt.JwtTokenFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity{
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	JwtEntryPoint jwtEntryPoint;

    @Bean
    JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()

                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()

                .antMatchers("/**").permitAll()

                .anyRequest().authenticated();

        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
    
    protected void configure(HttpSecurity http) throws Exception {


        List<String> list1 = Arrays.asList(new String[]{"Authorization", "Cache-Control", "Content-Type"});
        List<String> list2 = Arrays.asList(new String[]{"http://localhost:4200"});
        List<String> list3 = Arrays.asList(new String[]{"GET", "POST", "PUT", "DELETE", "OPTIONS"});
        List<String> list4 = Arrays.asList(new String[]{"Authorization"});

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(list1);
        corsConfiguration.setAllowedOrigins(list2);
        corsConfiguration.setAllowedMethods(list3);
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(list4);

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().configurationSource(request -> corsConfiguration);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}