package backend.com.backend.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "Title is missing")
        @Size(min = 15, max = 150,  message = "Title must be at least 15 characters and cannot be longer than 150 characters")
        private String title;

        @NotBlank(message = "Body is missing.")
        private String body;

        @NotBlank(message = "Detail is missing.")
        private String details;


    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private Long id;

        @NotBlank(message = "Title is missing")
        @Size(min = 15, max = 150,  message = "Title must be at least 15 characters and cannot be longer than 150 characters")
        private String title;

        @NotBlank(message = "Body is missing.")
        private String body;

        @NotBlank(message = "Detail is missing.")
        private String details;


        public void setQuestionId(long id) {
            this.id = id;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String body;
        private String details;

    }
}
