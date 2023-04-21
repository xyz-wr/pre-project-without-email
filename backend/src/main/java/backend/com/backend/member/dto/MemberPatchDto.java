package backend.com.backend.member.dto;

import backend.com.backend.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberPatchDto {
    private long id;
    private String email;
    private String displayName;
    private String fullName;
    private String password;
    private String location;

    public void setId(long id) {
        this.id = id;
    }
}
