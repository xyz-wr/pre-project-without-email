package backend.com.backend.answer.controller;

import backend.com.backend.answer.dto.AnswerDto;
import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.mapper.AnswerMapper;
import backend.com.backend.answer.service.AnswerService;
import backend.com.backend.question.entity.Question;
import backend.com.backend.utils.UriCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions/{question-id}")
// /users/{user-id}/answers
@CrossOrigin
public class AnswerController {

    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerService answerService;
    private final AnswerMapper mapper;
    private final Question question;

    @Autowired
    public AnswerController(AnswerService answerService, AnswerMapper mapper, Question question) {
        this.answerService = answerService;
        this.mapper = mapper;
        this.question = question;
    }

        @PostMapping
        public ResponseEntity postAnswer (@RequestBody AnswerDto.Post requestBody){
            Answer answer = mapper.answerPostDtoToAnswer(requestBody);

            Answer createdAnswer = answerService.createAnswer(answer);
            URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createdAnswer.getId());

            return ResponseEntity.created(location).build();

        }
        @GetMapping
        public ResponseEntity getAnswers (@PathVariable("question-id") long questionId,
        @Positive @RequestParam int page,
        @Positive @RequestParam int size,
        @RequestParam String sortOption){
            Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size, sortOption);
            List<Answer> Answers = pageAnswers.getContent();
            //특정 질문Id에 따른 전체 답변 목록이라..
            //Question 도메인에 있는 getAnswers()메소드로 따로 불러오는게 best일듯

        }

        @PatchMapping("/{answer-id}")
        public ResponseEntity patchAnswer () {

    }
}
