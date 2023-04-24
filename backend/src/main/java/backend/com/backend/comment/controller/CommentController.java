package backend.com.backend.comment.controller;

import backend.com.backend.answer.entity.Answer;
import backend.com.backend.answer.service.AnswerService;
import backend.com.backend.comment.dto.CommentDto;
import backend.com.backend.comment.entity.Comment;
import backend.com.backend.comment.mapper.CommentMapper;
import backend.com.backend.comment.service.CommentService;
import backend.com.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/answers/{answer-id}/comments")
@Validated
public class CommentController {
    private final static String COMMENT_DEFAULT_URL = "/answers/{answer-id}/comments";
    private final CommentService commentService;
    private final AnswerService answerService;
    private final CommentMapper mapper;
    @Autowired
    public CommentController(CommentService commentService, AnswerService answerService, CommentMapper mapper) {
        this.commentService = commentService;
        this.answerService = answerService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postComment(@PathVariable("answer-id") long answerId,
                                      @Valid @RequestBody CommentDto.Post requestBody) {
        Answer answer = answerService.findVerifiedAnswer(answerId);
        Comment comment = mapper.commentPostDtoToComment(requestBody);

        answer.setComment(comment);
        Comment createdComment = commentService.createComment(comment);

        URI location = UriComponentsBuilder
                .newInstance()
                .path(COMMENT_DEFAULT_URL + createdComment.getId())
                .buildAndExpand(createdComment.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                       @Valid @RequestBody CommentDto.Patch requestBody) {
        requestBody.setCommentId(commentId);
        Comment comment = mapper.commentPatchDtoToComment(requestBody);
        Comment updatedComment = commentService.updateComment(comment);

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(updatedComment), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(@PathVariable("comment-id") @Positive long commentId) {
        commentService.clearComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //이미 답변엔티티에 리스트<comment> 필드로 있기 때문에 댓글전체를 GET할 필요가 없다.
    /*@GetMapping
    public ResponseEntity getComments(@PathVariable("answer-id") long answerId) {
        List<Comment> comments = commentService.findComments(answerId);
        List<CommentDto.Response> commentList = mapper.commentToCommentResponseDtos(comments);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }*/
}
