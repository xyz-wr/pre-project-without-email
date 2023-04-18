package backend.com.backend.user.dto;

import backend.com.backend.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserPatchDto {
    private Long userid;
    private String email;
    private String full_name;
    private String display_name;
    private String password;
    private String location;
    private int total_questions;
    private int total_answers;
    private User.UserStatus user_status;

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
