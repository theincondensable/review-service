package io.incondensable.review.domain.repository;

public interface ManagerRepository {

    void updateUnapprovedComment(Long managerId, Long commentId);

    void updateUnapprovedVote(Long managerId, Long voteId);

}
