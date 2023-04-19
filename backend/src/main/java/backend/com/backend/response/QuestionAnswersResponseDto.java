package backend.com.backend.response;

import backend.com.backend.question.dto.QuestionDto;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class QuestionAnswersResponseDto<T> {
    private QuestionDto.Response question;
    private List<T> answers;
    private PageInfo pageInfo;

    public QuestionAnswersResponseDto(QuestionDto.Response question, List<T> answers, Page page) {
        this.question = question;
        this.answers = answers;
        this.pageInfo = new PageInfo(page.getNumber() + 1,
                page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
