package backend.com.backend.auth;

import backend.com.backend.auth.utils.MemberAuthorityUtils;
import backend.com.backend.exception.BusinessLogicException;
import backend.com.backend.exception.ExceptionCode;
import backend.com.backend.member.entity.Member;
import backend.com.backend.member.repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final MemberAuthorityUtils authorityUtils;

    //(2)
    public MemberDetailsService(MemberRepository memberRepository, MemberAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.authorityUtils = authorityUtils;
    }

    // (3)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByEmail(username);
        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        //주체, 크리덴셜, 권한정보 3가지를 가지고 있는 Authentication 토큰
        return new MemberDetails(findMember);
    }

    // (2) MemberDetails 클래스 추가
    private final class MemberDetails extends Member implements UserDetails {

        /*이렇게 구성하면 데이터베이스에서 조회한 회원 정보를 Spring Security의 User 정보로 변환하는 과정과 User의 권한 정보를 생성하는 과정을 캡슐화할 수 있습니다.*/
        MemberDetails(Member member) {
            setId(member.getId());
            setFullName(member.getFullName());
            setEmail(member.getEmail());
            setPassword(member.getPassword());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorityUtils.createAuthorities(this.getEmail());  // (2-3) 리팩토링 포인트
        }

        // (2-4)
        @Override
        public String getUsername() {
            return getEmail(); //extends Member를 했기 때문에 ㅇㅋ
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
