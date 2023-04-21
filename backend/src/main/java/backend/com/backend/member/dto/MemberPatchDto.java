package backend.com.backend.member.dto;

import backend.com.backend.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberPatchDto {
    private long id;
    private String email;
    private String fullName;
    private String displayName;
    private String password;
    private String location;
    private int totalQuestions;
    private int totalAnswers;
    private Member.MemberStatus memberStatus;

    public void setId(Long userId) {
        this.id = userId;
    }
}
