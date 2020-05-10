package ir.ac.sbu.hodhod.hodhod.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userService;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        auth.authenticationProvider(new CustomAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()


                .formLogin()
                .loginPage("/signup")
                .loginProcessingUrl("/loginmm")
                .defaultSuccessUrl("/")
//                .failureUrl("/login?error=true")
                .usernameParameter("email")
                .usernameParameter("phoneNumber")
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();

        http.exceptionHandling().accessDeniedPage("/login");
        //use JWT
        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }
}
