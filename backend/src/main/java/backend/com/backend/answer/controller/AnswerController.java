package backend.com.backend.answer.controller;

import backend.com.backend.answer.dto.AnswerDto;
import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.mapper.AnswerMapper;
import backend.com.backend.answer.service.AnswerService;
import backend.com.backend.question.entity.Question;
import backend.com.backend.question.mapper.QuestionMapper;
import backend.com.backend.question.service.QuestionService;
import backend.com.backend.response.QuestionAnswersResponseDto;
import backend.com.backend.utils.UriCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions/{question-id}/users/{user-id}/answers")
// /users/{user-id}/answers
@CrossOrigin
public class AnswerController {

    private final static String ANSWER_DEFAULT_URL = "/questions/{question-id}/users/{user-id}/answers";
    private final AnswerService answerService;
    private final QuestionService questionService;
    private final AnswerMapper mapper;
    @Autowired
    public AnswerController(AnswerService answerService, QuestionService questionService, AnswerMapper mapper) {
        this.answerService = answerService;
        this.questionService = questionService;
        this.mapper = mapper;
    }






        @PostMapping
        public ResponseEntity postAnswer (@PathVariable("question-id") long questionId,
                                          @RequestBody AnswerDto.Post requestBody){

            Answer answer = mapper.answerPostDtoToAnswer(requestBody);

            Answer createdAnswer = answerService.createAnswer(answer);
            createdAnswer.setQuestion(questionService.findByQuestionId(questionId));
            URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createdAnswer.getId());

            return ResponseEntity.created(location).build();

        }

        @PatchMapping("/{answer-id}")
        public ResponseEntity patchAnswer () {
        return null;
    }
}
