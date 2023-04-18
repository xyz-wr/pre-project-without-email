package backend.com.backend.user.dto;

import backend.com.backend.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
    private String email;
    private String full_name;
    private String display_name;
    private String password;
    private String location;
    private int total_questions;
    private int total_answers;
    private User.UserStatus user_status;


}