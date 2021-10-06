package warehouseapp.warehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//config + bean
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                // authority yoki huqu based
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("123")).authorities("ADD_CATEGORY", "READ_CATEGORY", "UPDATE_CATEGORY", "DELETE_CATEGORY")
                .and()
                .withUser("user").password(passwordEncoder().encode("user")).authorities("READ_CATEGORY", "READ_ONE_PRODUCT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("root123")).authorities("ADD_CATEGORY", "READ_CATEGORY");

//                role based auth
//                .inMemoryAuthentication()
//                .withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
//                .and()
//                .withUser("operator").password(passwordEncoder().encode("root123")).roles("OPERATOR");
    }

    //form based dan http bassicga o'tdik
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //eng kichik huquq
//                .antMatchers(HttpMethod.POST, "/api/category/**").hasAuthority("ADD_CATEGORY")
//                .antMatchers(HttpMethod.GET, "/api/category/**").hasAuthority("READ_CATEGORY")
//                .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/api/product/**").hasAnyRole("ADMIN", "OPERATOR")
////                .antMatchers(HttpMethod.POST, "/api/client/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/category/**").hasAnyRole("ADMIN", "OPERATOR", "USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    //paswordni shifrlash
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
