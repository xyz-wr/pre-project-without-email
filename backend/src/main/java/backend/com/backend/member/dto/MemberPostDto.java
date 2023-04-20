package backend.com.backend.member.dto;

import backend.com.backend.member.entity.Member;
import lombok.Getter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
public class MemberPostDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String displayName;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, updatable = false)
    private String password;
    @Column(updatable = false)
    private String location;
}
