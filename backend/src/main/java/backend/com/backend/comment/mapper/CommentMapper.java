package backend.com.backend.comment.mapper;

import backend.com.backend.comment.dto.CommentDto;
import backend.com.backend.comment.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment commentPostDtoToComment(CommentDto.Post requestBody);
    Comment commentPatchDtoToComment(CommentDto.Patch requestBody);
    CommentDto.Response commentToCommentResponseDto(Comment comment);
    List<CommentDto.Response> commentToCommentResponseDtos(List<Comment> comments);

}
