package backend.com.backend.member.mapper;

import backend.com.backend.member.dto.MemberPatchDto;
import backend.com.backend.member.dto.MemberPostDto;
import backend.com.backend.member.dto.MemberResponseDto;
import backend.com.backend.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper
public interface MemberMapper {
    Member UserPostDtoToUser(MemberPostDto memberPostDto);
    Member UserPatchDtoToUser(MemberPatchDto memberPatchDto);
    MemberResponseDto UserToResponseDto(Member member);
    //추후에 물어보자
//    List<UserResponseDto> usersToUserResponseDtos(List<User> users);
}
