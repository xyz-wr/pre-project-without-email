package backend.com.backend.member.mapper;

import backend.com.backend.member.dto.MemberPatchDto;
import backend.com.backend.member.dto.MemberPostDto;
import backend.com.backend.member.dto.MemberResponseDto;
import backend.com.backend.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member MemberPostDtoToMember(MemberPostDto memberPostDto);
    Member MemberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto MemberToResponseDto(Member member);
    //추후에 물어보자
//    List<MemberResponseDto> MembersToMemberResponseDtos(List<User> users);
}
