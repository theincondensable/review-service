package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.UserCommentRequestDto;
import io.incondensable.review.web.dto.UserVoteRequestDto;

public interface UserService {

    void postComment(UserCommentRequestDto request);

    void addVote(UserVoteRequestDto request);

}
