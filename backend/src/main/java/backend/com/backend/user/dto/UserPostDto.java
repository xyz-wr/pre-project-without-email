package backend.com.backend.user.dto;

import backend.com.backend.user.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserPostDto {
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
    private User.UserStatus user_status;
}
