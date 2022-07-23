package io.incondensable.review.domain.repository;

import io.incondensable.review.domain.model.Vote;

import java.util.List;

public interface VoteRepository {

    List<Vote> getVotesOfProduct(Long productId);

    List<Vote> getApprovedVotesOfProduct(Long productId);

}
