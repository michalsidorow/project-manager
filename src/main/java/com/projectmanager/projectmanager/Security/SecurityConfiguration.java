package com.projectmanager.projectmanager.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private BCryptPasswordEncoder passwordEncoder;

    public SecurityConfiguration(DataSource dataSource, BCryptPasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled " +
                        "from user_accounts where username = ?")
                .authoritiesByUsernameQuery("select username, role " +
                        "from user_accounts where username = ?")
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/projects/new").hasRole("ADMIN")
                .antMatchers("/projects/save").hasRole("ADMIN")
                .antMatchers("/employees/new").hasRole("ADMIN")
                .antMatchers("/employees/save").hasRole("ADMIN")
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin();
    }
}
