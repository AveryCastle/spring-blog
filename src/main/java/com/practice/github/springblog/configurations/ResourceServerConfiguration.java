package com.practice.github.springblog.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                    .frameOptions()
                    .disable()
                    .and()
                .authorizeRequests()
                    .antMatchers("/", "/h2-console/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/posts").permitAll()
                    .antMatchers(HttpMethod.POST, "/posts").authenticated();
    }
}
