package backend.com.backend.member.dto;

import backend.com.backend.member.entity.Member;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
public class MemberPostDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String full_name;
    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String display_name;
    private String password;
    private String location;
    private int total_questions;
    private int total_answers;
    private Member.UserStatus user_status;
}
