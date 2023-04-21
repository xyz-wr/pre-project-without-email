package backend.com.backend.member.service;

import backend.com.backend.exception.BusinessLogicException;
import backend.com.backend.exception.ExceptionCode;
import backend.com.backend.member.entity.Member;
import backend.com.backend.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member){
        //이메일 확인
        verifyExistsEmail(member.getEmail());
        return  memberRepository.save(member);
    }



    public Member updateMember(Member member){//추가 해야함
        //유저 존재 유무 확인
        Member findmember = findVerifiedMember(member.getId());

        Optional.ofNullable(member.getEmail())
                .ifPresent(email -> findmember.setEmail(email));
        Optional.ofNullable(member.getFullName())
                .ifPresent(fullName -> findmember.setFullName(fullName));
        Optional.ofNullable(member.getDisplayName())
                .ifPresent(displayName->findmember.setDisplayName(displayName));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password->findmember.setPassword(password));
        Optional.ofNullable(member.getLocation())
                .ifPresent(location->findmember.setLocation(location));

        //추후 수정
//        finduser.getModifiedAt()
        return memberRepository.save(findmember);

    }
    @Transactional(readOnly = true)
    public Member findMember(long userId){

        return findVerifiedMember(userId);
    }
    public Page<Member> findMembers(int page, int size){
        return memberRepository.findAll(PageRequest.of(page,size, Sort.by("Id").descending()));
    }
    public Member deleteMember(long userId){
        Member finduser = findVerifiedMember(userId);
        finduser.setMember_status(Member.MemberStatus.MEMBER_QUIT);
        return finduser;
    }

    //member Id 검색
    public Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(()->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }
    //member email 존재하는지 검증
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            //예외 처리 구현하면 추후 수정해야함.
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
