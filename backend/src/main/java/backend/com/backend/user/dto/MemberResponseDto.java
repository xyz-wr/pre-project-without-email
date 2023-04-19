package backend.com.backend.user.dto;

import backend.com.backend.user.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDto {
    private String email;
    private String display_name;
    private String location;
    private int total_questions;
    private int total_answers;

}