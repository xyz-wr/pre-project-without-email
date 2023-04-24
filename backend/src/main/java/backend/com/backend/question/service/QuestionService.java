package backend.com.backend.question.service;

import backend.com.backend.answer.entity.Answer;
import backend.com.backend.exception.BusinessLogicException;
import backend.com.backend.exception.ExceptionCode;
import backend.com.backend.member.entity.Member;
import backend.com.backend.member.repository.MemberRepository;
import backend.com.backend.question.entity.Question;
import backend.com.backend.question.mapper.QuestionMapper;
import backend.com.backend.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;
    private final QuestionMapper mapper;

    public QuestionService(QuestionRepository questionRepository, MemberRepository memberRepository, QuestionMapper mapper) {
        this.questionRepository = questionRepository;
        this.memberRepository = memberRepository;
        this.mapper = mapper;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        Question findQuestion = findByQuestionId(question.getId());
        Optional.ofNullable(question.getTitle())
                .ifPresent(title-> findQuestion.setTitle(title));
        Optional.ofNullable(question.getBody())
                .ifPresent(body -> findQuestion.setBody(body));

        return questionRepository.save(findQuestion);
    }

    public Question findQuestion(long questionId) {
        return findByQuestionId(questionId);
    }

    public List<Question> findQuestions() {

        return (List<Question>) questionRepository.findAll();
    }

    public void deleteQuestion(long questionId) {

        questionRepository.delete(findByQuestionId(questionId));
    }

    public Question findByQuestionId(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }
}
