package backend.com.backend.member.controller;

import backend.com.backend.member.dto.MemberPatchDto;
import backend.com.backend.member.dto.MemberPostDto;
import backend.com.backend.member.entity.Member;
import backend.com.backend.member.mapper.MemberMapper;
import backend.com.backend.member.service.MemberService;
import backend.com.backend.utils.UriCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/users")
@Validated
public class MemberController {
    private final static String USER_DEFAULT_URL = "/users";
    private final MemberMapper memberMapper;
    private final MemberService memberService;

    public MemberController(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }
    @PostMapping
    public ResponseEntity postUser(@Valid @RequestBody MemberPostDto memberPostDto){
        Member member = memberMapper.MemberPostDtoToMember(memberPostDto);
        Member data= memberService.createMember(member);

        URI location = UriCreator.createUri(USER_DEFAULT_URL, member.getId());//데이터베이스에 저장된 리소스의 위치를 알려주는 위치 정보
        return ResponseEntity.created(location).build();
    }
    @PatchMapping("/{user_Id}")
    public ResponseEntity patchUser(@PathVariable("user_Id") @Positive Long userId,
                                    @Valid @RequestBody MemberPatchDto memberPatchDto){
        memberPatchDto.setUserid(userId);
        Member member = memberMapper.MemberPatchDtoToMember(memberPatchDto);
        Member data = memberService.updateMember(member);

        return new ResponseEntity<>(memberMapper.MemberToResponseDto(data),HttpStatus.OK);
    }
    @GetMapping("/{user_Id}")
    public ResponseEntity getUser(@PathVariable("user_Id") @Positive Long userId){
        Member data = memberService.findMember(userId);

        return new ResponseEntity<>(memberMapper.MemberToResponseDto(data),HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity getUsers(@Positive @RequestParam int page,
//                                   @Positive @RequestParam int size){
//        Page<User> pageusers = userService.findUsers(page -1, size);
//        List<User> users = pageusers.getContent();
//        return null;
//    }
    @DeleteMapping("/{user_Id}")
    public ResponseEntity deleteUser(@PathVariable("user_Id") @Positive Long userId){
        Member data = memberService.deleteMember(userId);

        return new ResponseEntity<>(memberMapper.MemberToResponseDto(data),HttpStatus.OK);
    }
}
