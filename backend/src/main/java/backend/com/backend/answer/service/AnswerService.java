package backend.com.backend.answer.service;

import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.repository.AnswerRepository;
import backend.com.backend.exception.BusinessLogicException;
import backend.com.backend.exception.ExceptionCode;
import backend.com.backend.member.repository.MemberRepository;
import backend.com.backend.question.repository.QuestionRepository;
import backend.com.backend.question.service.QuestionService;
import backend.com.backend.utils.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final CustomBeanUtils<Answer> beanUtils;
    @Autowired
    public AnswerService(AnswerRepository answerRepository, CustomBeanUtils<Answer> beanUtils) {
        this.answerRepository = answerRepository;
        this.beanUtils = beanUtils;
    }

    public Answer createAnswer(Answer answer) {
        //Answer 엔티티의 Quesition필드를 세팅한다.
        //relatedQuestion.setAnswer(answer);
        //vice versa로 상위 질문 엔티티의 Answer 필드를 세팅한다.
        //questionRepository.save(relatedQuestion);
        //QuestionRepository객체를 이용해 Question 테이블에 질문 엔티티의 변경사항을 저장한다.
        return answerRepository.save(answer);
        //vice versa로 Answer 테이블에 답변 엔티티의 변경사항을 저장하고 Controller단으로 리턴한다.
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getId());

        Answer updatedAnswer = beanUtils.copyNonNullProperties(answer, findAnswer);

        return answerRepository.save(updatedAnswer);
    }

    public List<Answer> findAnswers(long questionId) {
        //질문 엔티티는 delete시 완전삭제이니 안심하고 fidnAll해도
        //memberStatus로 삭제를 관리하는 유저 엔티티는 다른 방식의 접근이 필요
        List<Answer> answers = answerRepository.findAllByQuestionId(questionId);

        return answers;
    }

    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer =
                optionalAnswer.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return findAnswer;
    }

    public void clearAnswer(long answerId) {
        answerRepository.delete(findVerifiedAnswer(answerId));
    }

    public Page<Answer> makePageObject(int page, int size, List<Answer> answers) {
        int pageNumber = page;
        int pageSize = size;
        int totalElements = answers.size();

        //Pageable object
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // calculate the start and end index of the sublist
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), totalElements);

        // create a sublist from the original list
        List<Answer> sublist = answers.subList(start, end);

        // create a PageImpl object
        Page<Answer> pageList = new PageImpl<>(sublist, pageable, totalElements);
        return pageList;
    }

    public Answer findAnswer(long answerId) {
        Answer foundAnswer = findVerifiedAnswer(answerId);
        return foundAnswer;
    }
}
