package backend.com.backend.answer.controller;

import backend.com.backend.answer.dto.AnswerDto;
import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.mapper.AnswerMapper;
import backend.com.backend.answer.service.AnswerService;
import backend.com.backend.question.dto.QuestionDto;
import backend.com.backend.question.entity.Question;
import backend.com.backend.question.mapper.QuestionMapper;
import backend.com.backend.response.QuestionAnswersResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@RestController
@RequestMapping("/api1/members/{member-id}/questions/{id}/answers")
// /users/{user-id}/answers
@Validated
@CrossOrigin
@Slf4j
public class AnswerController {

    private final static String ANSWER_DEFAULT_URL = "/api1/questions/{id}/answers";
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;
    private final QuestionMapper questionMapper;
    @Autowired
    public AnswerController(AnswerService answerService, AnswerMapper amapper, QuestionMapper qmapper) {
        this.answerService = answerService;
        this.answerMapper = amapper;
        this.questionMapper = qmapper;
    }

    @PostMapping
        public ResponseEntity postAnswer (@PathVariable("id") long questionId,
                                          @Valid @RequestBody AnswerDto.Post requestBody){

            Answer answer = answerMapper.answerPostDtoToAnswer(requestBody);
            Answer createdAnswer = answerService.createAnswer(questionId, answer);

            URI location = UriComponentsBuilder
                    .newInstance()
                    .path(ANSWER_DEFAULT_URL + createdAnswer.getId())
                    .buildAndExpand(createdAnswer.getId())
                    .toUri();

            return ResponseEntity.created(location).build();

        }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @Valid @RequestBody AnswerDto.Patch requestBody) {
        requestBody.setId(answerId);

        Answer answer =
                answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(requestBody));

        return new ResponseEntity<>(answerMapper.answerToAnswerResponseDto(answer), HttpStatus.OK);
    }


    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        answerService.clearAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // for GET
    //사실 아래 메소드는 비즈니스로직에 가까워서 AnswerService에 작성이 원칙이다.
    //그렇다고 AnswerService에 작성하자면
    //questionMapper answerMapper를 또 AnswerService단에서 DI받아야한다.
    //그러니 차라리 예외적으로 컨트롤러 단에서 있도록 해주었다.
    public ResponseEntity<?> bySortOption(long questionId, int page, int size, String sortOption, Question question) {
        QuestionDto.Response questionResponse = questionMapper.questionToQuestionResponseDto(question);

        if(question.getAnswers().size() == 0) {
            return new ResponseEntity<>(questionResponse, HttpStatus.OK);
        }
        else {
            if(sortOption == null){
                List<Answer> answers = answerService.findAnswers(questionId);
                Page<Answer> pageAnswers = answerService.makePageObject(page -1, size, answers);
                List<AnswerDto.Response> answerResponses =
                        answers.stream()
                                .sorted(comparing(Answer::getId).reversed())
                                .map(answer -> answerMapper.answerToAnswerResponseDto(answer))
                                .collect(Collectors.toList());
                return new ResponseEntity<>(new QuestionAnswersResponseDto<>(questionResponse, answerMapper.answersToAnswerResponseDtos(answers), pageAnswers), HttpStatus.OK);
            }

            else if(sortOption.equals("newest")){
                List<Answer> answers = answerService.findAnswers(questionId);
                Page<Answer> pageAnswers = answerService.makePageObject(page -1, size, answers);
               //List<Answer> finalAnswers = pageAnswers.getContent();
                List<AnswerDto.Response> answerResponses =
                        answers.stream()
                                .sorted(comparing(Answer::getId).reversed())
                                .map(answer -> answerMapper.answerToAnswerResponseDto(answer))
                                .collect(Collectors.toList());
                return new ResponseEntity<>(new QuestionAnswersResponseDto<>(questionResponse, answerMapper.answersToAnswerResponseDtos(answers), pageAnswers), HttpStatus.OK);
            }
            else if(sortOption.equals("oldest")){
                List<Answer> answers = answerService.findAnswers(questionId);
                Page<Answer> pageAnswers = answerService.makePageObject(page -1, size, answers);
                List<AnswerDto.Response> answerResponses =
                        answers.stream()
                                .map(answer -> answerMapper.answerToAnswerResponseDto(answer))
                                .collect(Collectors.toList());
                return new ResponseEntity<>(new QuestionAnswersResponseDto<>(questionResponse, answerMapper.answersToAnswerResponseDtos(answers), pageAnswers), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(questionResponse, HttpStatus.OK);
    }
}
