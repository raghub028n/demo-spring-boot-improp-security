package com.raghu.sample.configuration;

import com.raghu.sample.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    CorsFilter corsFilter(){
        return new CorsFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(corsFilter(), SessionManagementFilter.class);
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll();
        http.authorizeRequests().antMatchers("/docs/**").permitAll();
        http.authorizeRequests().antMatchers("/api/**").permitAll();
        //http.authorizeRequests().anyRequest().authenticated(); //implement logic for authentication and enable this
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
