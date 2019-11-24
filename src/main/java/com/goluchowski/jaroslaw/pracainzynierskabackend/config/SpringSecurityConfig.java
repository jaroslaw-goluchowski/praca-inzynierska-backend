package com.goluchowski.jaroslaw.pracainzynierskabackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.anonymous().and()
                .authorizeRequests()
                    .antMatchers("/", "/home", "/about", "/v1/**", "/swagger-ui.html").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and().
                    authorizeRequests().antMatchers("/resources/**", "/static/**","/webjars/**").permitAll()
                .and()
                    .authorizeRequests()
                    .antMatchers("/admin/**").hasAnyRole("ADMIN")
                    .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**","/webjars/**","/css/**","/fonts/**","/libs/**","/v1/**");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

}
