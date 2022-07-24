package io.incondensable.review.data.repository;

import io.incondensable.review.data.dao.CommentDao;
import io.incondensable.review.data.dao.VoteDao;
import io.incondensable.review.domain.repository.ManagerRepository;
import io.incondensable.review.global.constants.Constants;
import io.incondensable.review.global.exception.business.BusinessException;
import io.incondensable.review.global.exception.business.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class ManagerRepositoryImpl implements ManagerRepository {

    private final CommentDao commentDao;
    private final VoteDao voteDao;

    public ManagerRepositoryImpl(CommentDao commentDao, VoteDao voteDao) {
        this.commentDao = commentDao;
        this.voteDao = voteDao;
    }

    @Override
    @Transactional
    public void updateUnapprovedComment(Long managerId, Long commentId) {
        validateManagerForApprovingComment(managerId, commentId);

        commentDao.approveComment(Constants.VoteAndCommentStatus.APPROVED.getValue(), commentId);
    }

    @Override
    @Transactional
    public void updateUnapprovedVote(Long managerId, Long voteId) {
        validateManagerForApprovingVote(managerId, voteId);

        voteDao.approveVote(Constants.VoteAndCommentStatus.APPROVED.getValue(), voteId);
    }

    private void validateManagerForApprovingComment(Long managerId, Long commentId) {
        if (commentDao.isManagerTheOwnerOfProductForApprovingComment(managerId, commentId) == 0) {
            throw new BusinessException(
                    new ExceptionMessage(
                            "manager.is.not.allowed.to.approve.this.comment",
                            HttpStatus.FORBIDDEN,
                            new Object[]{managerId, "Comment"}
                    )
            );
        }
    }

    private void validateManagerForApprovingVote(Long managerId, Long voteId) {
        if (voteDao.isManagerTheOwnerOfProductForApprovingVote(managerId, voteId) == 0) {
            throw new BusinessException(
                    new ExceptionMessage(
                            "manager.is.not.allowed.to.approve.this.vote",
                            HttpStatus.FORBIDDEN,
                            new Object[]{managerId}
                    )
            );
        }
    }

}
