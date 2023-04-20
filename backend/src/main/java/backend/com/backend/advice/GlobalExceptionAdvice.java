package backend.com.backend.advice;

import backend.com.backend.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //필드 유효성검사 실패, 변수값 등등 요청,검증 단계 예외처리
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e){
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());
        return response;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //JPA에서 제약 조건 위반 예외 처리,(ex : DB에 저장할려는데 유효성 검사 실패)
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e){
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());
        return response;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    //모든 예외를 처리하는 메소드(디폴트)
    public ErrorResponse handleException(Exception e){
        final ErrorResponse response = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
