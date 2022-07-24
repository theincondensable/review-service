package io.incondensable.review.domain.service;

import io.incondensable.review.domain.repository.ManagerRepository;
import io.incondensable.review.web.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository repository;

    public ManagerServiceImpl(ManagerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void approveComment(Long managerId, Long commentId) {
        repository.updateUnapprovedComment(managerId, commentId);
    }

    @Override
    public void approveVote(Long managerId, Long voteId) {
        repository.updateUnapprovedVote(managerId, voteId);
    }

}
