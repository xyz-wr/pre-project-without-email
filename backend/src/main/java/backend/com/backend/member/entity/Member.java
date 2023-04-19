package backend.com.backend.member.entity;

import javax.persistence.*;



import backend.com.backend.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(nullable = false)
    private int total_questions;
    @Column(nullable = false)
    private int total_answers;

    @Enumerated(value=EnumType.STRING)
    @Column(nullable = false)
    private UserStatus user_status = UserStatus.USER_ACTIVE;


//    @OneToMany(mappedBy = "user")
//    private List<Question> question;
//
//    @OneToMany(mappedBy = "user")
//    private List<Answer> answer;
//
//    @OneToMany(mappedBy ="user")
//    private List<Comment> comment;

    public enum UserStatus{
        USER_ACTIVE("활동 중"),
        USER_SLEEP("휴면 상태"),
        USER_QUIT("탈퇴 상태");
        @Getter
        private String statusDesciption;

        UserStatus(String statusDesciption) {
            this.statusDesciption = statusDesciption;
        }
    }
}