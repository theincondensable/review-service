package io.incondensable.review.domain.service;

import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.domain.repository.UserRepository;
import io.incondensable.review.global.constants.Constants;
import io.incondensable.review.web.dto.UserCommentRequestDto;
import io.incondensable.review.web.dto.UserVoteRequestDto;
import io.incondensable.review.web.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void postComment(UserCommentRequestDto request) {
        repository.postComment(
                Comment.buildFromDto(
                        request.getCommentContext(),
                        Constants.VoteAndCommentStatus.NOT_APPROVED.getValue(),
                        request.getProductId(),
                        request.getUserId()
                )
        );
    }

    @Override
    public void addVote(UserVoteRequestDto request) {
        repository.postVote(
                Vote.buildFromDto(
                        request.getVoteScore(),
                        Constants.VoteAndCommentStatus.NOT_APPROVED.getValue(),
                        request.getProductId(),
                        request.getUserId()
                )
        );
    }

}
