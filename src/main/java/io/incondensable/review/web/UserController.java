package io.incondensable.review.web;

import io.incondensable.review.web.dto.UserCommentRequestDto;
import io.incondensable.review.web.dto.UserVoteRequestDto;
import io.incondensable.review.web.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User Controller", description = "Responsible for Users who want to post a Comment or Vote on a Product.")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("post/comment")
    public void postCommentWithUserId(@RequestBody UserCommentRequestDto request) {
        service.postComment(request);
    }

    @PostMapping("add/vote")
    public void addVoteWithUserId(@RequestBody UserVoteRequestDto request) {
        service.addVote(request);
    }

}
