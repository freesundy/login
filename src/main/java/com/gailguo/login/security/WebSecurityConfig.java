package com.gailguo.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AjaxAuthSuccessHandler successHandler;

    @Autowired
    private AjaxAuthFailureHandler failureHandler;

    @Autowired
    private AjaxLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     *
     * 1.  authorizeRequests() .antMatchers("/user/*").permitAll()  .anyRequest().authenticated() 意思代表 /user 不需要进行授权认证，其他都需要认证。
     *
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() .antMatchers("/user/*").permitAll()  .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login.html").loginProcessingUrl("/signin").successHandler(successHandler).failureHandler(failureHandler)
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout().logoutUrl("/signout").logoutSuccessHandler(logoutSuccessHandler).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }
}
