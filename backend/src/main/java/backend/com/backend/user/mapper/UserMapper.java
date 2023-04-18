package backend.com.backend.user.mapper;

import backend.com.backend.user.dto.UserPatchDto;
import backend.com.backend.user.dto.UserPostDto;
import backend.com.backend.user.dto.UserResponseDto;
import backend.com.backend.user.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User UserPostDtoToUser(UserPostDto userPostDto);
    User UserPatchDtoToUser(UserPatchDto userPatchDto);
    UserResponseDto UserToResponseDto(User user);
}
