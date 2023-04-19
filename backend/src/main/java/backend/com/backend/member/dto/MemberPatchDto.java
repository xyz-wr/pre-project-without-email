package backend.com.backend.member.dto;

import backend.com.backend.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberPatchDto {
    private long userid;
    private String email;
    private String full_name;
    private String display_name;
    private String password;
    private String location;
    private int total_questions;
    private int total_answers;
    private Member.UserStatus user_status;

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
