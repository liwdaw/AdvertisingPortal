package com.liwdaw.AdvertisingPortal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private static final String[] AUTH_WHITELIST = {
            "/index.html",
            "/settings.html",
            "/admin.html",
            "/ad.html",
            "/sign_in.html",
            "/register.html",
            "/terms_and_conditions.html",
            "/about.html",
            "/add_ad.html",
            "/theme.css",
            "/theme.scss",
            "/images/**",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "/user/register",
            "/ad/ad_id*",
            "/ad/subcategory_id*",
            "/ad/category_id*",
            "/ad/user_id*"
    };
    
    @Autowired
    private CustomUserDetailsService detailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/**/*").authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
    
}