package io.incondensable.review.domain.repository;

import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.domain.model.Vote;

public interface UserRepository {

    void postComment(Comment comment);

    void postVote(Vote vote);

}
