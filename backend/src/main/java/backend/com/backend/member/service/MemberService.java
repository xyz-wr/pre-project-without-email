package backend.com.backend.member.service;

import backend.com.backend.member.entity.Member;
import backend.com.backend.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createUser(Member member){
        //이메일 확인
        verifyExistsEmail(member.getEmail());
        return  memberRepository.save(member);
    }



    public Member updateUser(Member member){//추가 해야함
        //유저 존재 유무 확인
        Member finduser = findVerifiedUser(member.getId());

        Optional.ofNullable(member.getFullName())
                .ifPresent(fullName -> finduser.setFullName(fullName));
        Optional.ofNullable(member.getDisplayName())
                .ifPresent(displayName->finduser.setDisplayName(displayName));
        Optional.ofNullable(member.getLocation())
                .ifPresent(location->finduser.setLocation(location));
        Optional.ofNullable(member.getDisplayName())
                .ifPresent(displayName->finduser.setDisplayName(displayName));
        Optional.ofNullable(member.getUser_status())
                .ifPresent(userStatus->finduser.setUser_status(userStatus));

        //추후 수정
//        finduser.getModifiedAt()
        return memberRepository.save(finduser);

    }
    public Member findUser(long userId){

        return findVerifiedUser(userId);
    }
    public Page<Member> findUsers(int page, int size){
        return memberRepository.findAll(PageRequest.of(page,size, Sort.by("Id").descending()));
    }
    public Member deleteUser(long userId){
        Member finduser = findVerifiedUser(userId);
        finduser.setUser_status(Member.UserStatus.USER_QUIT);
        return finduser;
    }
    public Member findVerifiedUser(long userId){
        Optional<Member> optionalUser = memberRepository.findById(userId);
        //예외 처리 구현하면 추후 수정해야함.
        Member findMember = optionalUser.orElseThrow(IllegalArgumentException::new);
        return findMember;
    }
    private void verifyExistsEmail(String email) {
        Optional<Member> user = memberRepository.findByEmail(email);
        if (user.isPresent())
            //예외 처리 구현하면 추후 수정해야함.
            throw new RuntimeException("email exists");
    }
}
