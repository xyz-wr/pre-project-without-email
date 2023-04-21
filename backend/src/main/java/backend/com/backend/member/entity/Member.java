package backend.com.backend.member.entity;

import javax.persistence.*;


import backend.com.backend.answer.entity.Answer;
import backend.com.backend.audit.Auditable;
import backend.com.backend.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String displayName;
    @Column(nullable = false, updatable = false)
    private String password;
    @Column(updatable = false)
    private String location;

    @Enumerated(value=EnumType.STRING)
    @Column(nullable = false)
    private MemberStatus member_status = MemberStatus.MEMBER_ACTIVE;
//    @OneToMany(mappedBy = "user")
//    private List<Question> question;
//
//    @OneToMany(mappedBy = "user")
//    private List<Answer> answer;
//
//    @OneToMany(mappedBy ="user")
//    private List<Comment> comment;
    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();

    /*@OneToMany
    private Comment comment;*/

    /*@OneToMany
    private User_anal useranal;*/
    public enum MemberStatus{
        MEMBER_ACTIVE("활동 중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");
        @Getter
        private String statusDesciption;

        MemberStatus(String statusDesciption) {
            this.statusDesciption = statusDesciption;
        }
    }
}