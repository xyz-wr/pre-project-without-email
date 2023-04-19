package backend.com.backend.answer.service;

import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.repository.AnswerRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> findAnswers(long questionId) {
        //질문 엔티티는 delete시 완전삭제이니 안심하고 fidnAll해도
        //memberStatus로 삭제를 관리하는 유저 엔티티는 다른 방식의 접근이 필요
        List<Answer> answers = answerRepository.findAllByQuestionId(questionId);

        return answers;
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

}
