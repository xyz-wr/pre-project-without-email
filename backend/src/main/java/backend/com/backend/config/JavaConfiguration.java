package backend.com.backend.config;

import backend.com.backend.member.repository.MemberRepository;
import backend.com.backend.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JavaConfiguration {
    //(1)
    @Bean
    public MemberService dbMemberService(MemberRepository memberRepository,
                                         PasswordEncoder passwordEncoder) {
        return new MemberService(memberRepository, passwordEncoder); //(1-1)
    }
}
