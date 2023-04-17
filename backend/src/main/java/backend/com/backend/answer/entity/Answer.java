package backend.com.backend.answer.entity;

import backend.com.backend.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String content;

    @Column
    private int score;
    //user_id, question_id 두 개의 필드만 추가하면 된다.

}
