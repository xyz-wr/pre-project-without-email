package backend.com.backend.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),// 존재하지 않는 회원
    QUESTION_NOT_FOUND(404,"Question Not Found"),//존재하지 않는 질문
    ANSWER_NOT_FOUND(404, "Answer Not Found"), //존재하지 않는 답변
    MEMBER_EXISTS(409, "Member exists"),
    QUESTION_EXISTS(409,"Question NOT FOUND");
    @Getter
    private final int status;

    @Getter
    private final String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
