package backend.com.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()                 // (1)
                .formLogin()                      // (2)
                .loginPage("/auths/login-form")   // (3)
                .loginProcessingUrl("/process_login")    // 클라이언트 코드 필요
                .failureUrl("/auths/login-form?error")   // 클라이언트 코드 필요
                .and() // (6)
                .logout()                        // (1)
                .logoutUrl("/logout")            // 여기서 설정한 URL은 코드 4-13 header.html의 로그아웃 메뉴에 지정한 href=”/logout”과 동일해야 합니다. (클라코드필요)
                .logoutSuccessUrl("/")  // (3) 기본 홈페이지 클라 코드 필요
                .and()
                .exceptionHandling().accessDeniedPage("/auths/access-denied")   //클라이언트 코드 필요
                .and()
                .authorizeHttpRequests(authorize -> authorize                  // (2)
                        .antMatchers("/questions/**").hasRole("ADMIN")        // (2-1)
                        .antMatchers("/members/my-page").hasRole("USER")   // 클라 코드 필요
                        .antMatchers("⁄**").permitAll()                    // (2-3)
                );


        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

//InMemoryUserDetailsManager implements UserDetailsManage extends UserDetailsService