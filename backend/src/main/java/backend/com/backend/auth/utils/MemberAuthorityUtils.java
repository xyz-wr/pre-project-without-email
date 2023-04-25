package backend.com.backend.auth.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import java.util.List;

import java.util.Collection;
@Component
public class MemberAuthorityUtils {
    @Value("${mail.address.admin}")
    private String adminMailAddress;
    // (2)
    private final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    // (3)
    private final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    public List<GrantedAuthority> createAuthorities(String email) {
        //(4)
        if(email.equals(adminMailAddress)) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }
}
