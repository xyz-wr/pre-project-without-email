package backend.com.backend.question.service;

import backend.com.backend.question.entity.Question;
import backend.com.backend.question.mapper.QuestionMapper;
import backend.com.backend.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper mapper;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper mapper) {
        this.questionRepository = questionRepository;
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
        Question findQuestion = findByQuestionId(questionId);
        questionRepository.delete(findQuestion);
    }

    public Question findByQuestionId(long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new RuntimeException());
        return findQuestion;
    }
}
