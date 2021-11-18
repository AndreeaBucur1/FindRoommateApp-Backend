package com.ub.fmi.demo;



import com.ub.fmi.demo.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Import(SecurityProblemSupport.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final SecurityProblemSupport problemSupport;

    public SecurityConfiguration(SecurityProblemSupport problemSupport) {
        this.problemSupport = problemSupport;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/users","/users/change-role/{id}","/login", "/register", "/forgot-password", "/forgot-password/reset-password", "/users/activate-account","/users/{id}")
                .permitAll().anyRequest().authenticated().and()
                .apply(new JwtConfigurer()).and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint(problemSupport).accessDeniedHandler(problemSupport).configure(http.cors().and());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public static class JwtConfigurer
            extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
        }
    }
}
