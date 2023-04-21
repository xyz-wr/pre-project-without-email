
package backend.com.backend.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
@AllArgsConstructor
public class MemberResponseDto {
    private long id;
    private String email;
    private String fullName;
    private String displayName;
    private String location;
    // 클라이언트에서 요청하는데 모니터상에서 민감정보를 보내는건 조금 아니다.
    //DTO를 쓰는이유가 엔티티와 클라이언트에 보내는거와 필드가 다르기때문에 나눌려고 쓰는거다.


}