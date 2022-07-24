package io.incondensable.review.web.service;

public interface ManagerService {

    void approveComment(Long managerId, Long commentId);

    void approveVote(Long managerId, Long voteId);
}
