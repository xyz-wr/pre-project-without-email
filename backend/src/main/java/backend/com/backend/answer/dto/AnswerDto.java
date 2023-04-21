package backend.com.backend.answer.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class AnswerDto {
    @Getter
    @Setter
    public static class Post {
        @NotEmpty(message = "답변의 내용을 정확히 기입하십시오")
        private String content;
    }
    @Getter
    @Setter
    public static class Patch {
        private long id;
        @NotEmpty(message = "수정할 답변의 내용을 적어주십시오.")
        private String content;
    }
    @Getter
    @Setter
    public static class Response {
        private long id;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
