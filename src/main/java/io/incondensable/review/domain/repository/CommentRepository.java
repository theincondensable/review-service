package io.incondensable.review.domain.repository;

import io.incondensable.review.domain.model.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> getCommentsOfProduct(Long productId);

    List<Comment> getApprovedCommentsOfProduct(Long productId);

}
