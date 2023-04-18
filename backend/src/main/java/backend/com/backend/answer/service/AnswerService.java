package backend.com.backend.answer.service;

import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.repository.AnswerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Page<Answer> findAnswers(long questionId, int page, int size, String sortOption) {
        //질문 엔티티는 delete시 완전삭제이니 안심하고 fidnAll해도
        //memberStatus로 삭제를 관리하는 유저 엔티티는 다른 방식의 접근이 필요
        //Page<Answer> blabla = 리팩털드메서드()
        Page<Answer> pageAnswerWithQuestionId = sortBySortOption(questionId, page, size, sortOption);

        return pageAnswerWithQuestionId;
    }

    private Page<Answer> sortBySortOption(long questionId, int page, int size, String sortOption) {
        if(sortOption.equals("newest")) {
            return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending())).stream().filter(el -> el.getQuestion().getId() == questionId).collect(Collectors.toList());
        }
        else if(sortOption.equals("oldest")) {
            return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").ascending())).stream().filter(el -> el.getQuestion().getId() == questionId).collect(Collectors.toList());
        }
        else if(sortOption.equals("score")) {
            return answerRepository.findAll(PageRequest.of(page, size, Sort.by("score").descending())).stream().filter(el -> el.getQuestion().getId() == questionId).collect(Collectors.toList());
        }
        return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending())).stream().filter(el -> el.getQuestion().getId() == questionId).collect(Collectors.toList());
        //정렬옵션을 선택하지 않았을때 기본 정렬 : 최신순
    }
}
