package backend.com.backend.answer.controller;

import backend.com.backend.answer.dto.AnswerDto;
import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.mapper.AnswerMapper;
import backend.com.backend.answer.service.AnswerService;
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

    @Autowired
    public AnswerController(AnswerService answerService, AnswerMapper mapper) {
        this.answerService = answerService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerDto.Post requestBody) {
        Answer answer = mapper.answerPostDtoToAnswer(requestBody);

        Answer createdAnswer = answerService.createAnswer(answer);
        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createdAnswer.getId());

        return ResponseEntity.created(location).build();

    }
    @GetMapping
    public ResponseEntity getAnswers(@PathVariable("question-id") long questionId,
                                     @Positive @RequestParam int page,
                                     @Positive @RequestParam int size,
                                     @RequestParam String sortOption) {
        Page<Answer> pageAnswers = answerService.findAnswers(questionId,page - 1, size, sortOption);
        List<Answer> Answers = pageAnswers.getContent();

    }
}
