//package backend.com.backend.Test;
//
//import backend.com.backend.question.dto.QuestionDto;
//import backend.com.backend.question.entity.Question;
//import backend.com.backend.question.mapper.QuestionMapper;
//import backend.com.backend.question.service.QuestionService;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
///*
//@WebMvcTest
// * JPA 기능은 동작하지 않는다.
// *  여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에만 집중할 수 있는 어노테이션
// *  @Controller, @ControllerAdvice 사용 가능
// *  단, @Service, @Repository등은 사용할 수 없다.
// * */
//@SpringBootTest
//@AutoConfigureMockMvc
//public class QuestionControllerTest {
//    @Autowired
//    private QuestionMapper mapper;
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    MockMvc mvc;
//
//    @Autowired
//    private Gson gson;
//
//    private static final String BASE_URL = "/api1/questions";
//    @Test
//    @DisplayName("post test")
//    void post_Test() throws Exception{
//        //given
//        QuestionDto.Post post = new QuestionDto.Post("우리집 정수기는 얼음 나오는 정수기","화이팅화이팅화이팅","아아아아나나나나나나");
//
//        Question question = mapper.questionPostDtoToQuestion(post);
//        question.setId(1L);
//
//        given(questionService.createQuestion(Mockito.any(Question.class)));
//        String content = gson.toJson(post);
//
//
//
//        //when : 테스트할 동작
//
//        //then
//
//    }
//
//}
