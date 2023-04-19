package backend.com.backend.answer.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class AnswerDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotEmpty(message = "답변의 내용을 적어주십시오.")
        private String content;
    }
    @Getter
    @Setter
    public static class Patch {

    }
    @Getter
    @Setter
    public static class Response {

    }
}
