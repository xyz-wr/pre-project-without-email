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

    public Page<Answer> findAnswers(int page, int size, String sortOption) {
        //질문 엔티티는 delete시 완전삭제이니 안심하고 fidnAll해도
        //memberStatus로 삭제를 관리하는 유저 엔티티는 다른 방식의 접근이 필요
        //Page<Answer> blabla = 리팩털드메서드()
        Page<Answer> pageAnswer = sortBySortOption(page, size, sortOption);

        return pageAnswer;
    }

    private Page<Answer> sortBySortOption(int page, int size, String sortOption) {
        if(sortOption.equals("newest")) {
            return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending()));
        }
        else if(sortOption.equals("oldest")) {
            return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").ascending()));
        }
        else if(sortOption.equals("score")) {
            return answerRepository.findAll(PageRequest.of(page, size, Sort.by("score").descending()));
        }
        return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending()));
        //정렬옵션을 선택하지 않았을때 기본 정렬 : 최신순
    }
}
