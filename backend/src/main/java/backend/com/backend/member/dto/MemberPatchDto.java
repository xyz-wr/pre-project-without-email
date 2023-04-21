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
    private String location;

    public void setId(Long userId) {
        this.id = userId;
    }
}
