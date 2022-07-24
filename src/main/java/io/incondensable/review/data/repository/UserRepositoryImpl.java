package io.incondensable.review.data.repository;

import io.incondensable.review.data.dao.CommentDao;
import io.incondensable.review.data.dao.ProductDao;
import io.incondensable.review.data.dao.UserPurchasedProductsDao;
import io.incondensable.review.data.dao.VoteDao;
import io.incondensable.review.data.mapper.impl.CommentMapper;
import io.incondensable.review.data.mapper.impl.VoteMapper;
import io.incondensable.review.data.model.ProductEntity;
import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.domain.model.Vote;
import io.incondensable.review.domain.repository.UserRepository;
import io.incondensable.review.global.constants.Constants;
import io.incondensable.review.global.exception.business.BusinessException;
import io.incondensable.review.global.exception.business.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserPurchasedProductsDao userPurchasedProductsDao;
    private final ProductDao productDao;
    private final CommentDao commentDao;
    private final VoteDao voteDao;

    private final CommentMapper commentMapper;
    private final VoteMapper voteMapper;

    public UserRepositoryImpl(UserPurchasedProductsDao userPurchasedProductsDao, ProductDao productDao, CommentDao commentDao, VoteDao voteDao, CommentMapper commentMapper, VoteMapper voteMapper) {
        this.userPurchasedProductsDao = userPurchasedProductsDao;
        this.productDao = productDao;
        this.commentDao = commentDao;
        this.voteDao = voteDao;
        this.commentMapper = commentMapper;
        this.voteMapper = voteMapper;
    }

    @Override
    public void postComment(Comment comment) {
        validateUserForPostingCommentAndVote(comment.getProductId(), comment.getUserId());

        commentDao.save(
                commentMapper.mapDomainToEntity(comment)
        );
    }

    @Override
    public void postVote(Vote vote) {
        validateUserForPostingCommentAndVote(vote.getProductId(), vote.getUserId());

        voteDao.save(
                voteMapper.mapDomainToEntity(vote)
        );
    }

    private void validateUserForPostingCommentAndVote(Long productId, Long userId) {
        boolean reviewable = isProductReviewableForAll(productId);

        if (!reviewable) {
            boolean doesUserOwnTheProduct = hasUserPurchasedTheProduct(userId, productId);
            if (!doesUserOwnTheProduct) {
                throw new BusinessException(
                        new ExceptionMessage(
                                "user.is.not.allowed.to.post.comment.or.vote",
                                HttpStatus.FORBIDDEN,
                                new Object[]{userId}
                        )
                );
            }
        }
    }

    private boolean isProductReviewableForAll(Long productId) {
        ProductEntity product = productDao.getById(productId);

        return product.getIsReviewAvailableForAll() != Constants.ProductStatus.NOT_REVIEWABLE.getValue();
    }

    private boolean hasUserPurchasedTheProduct(Long userId, Long productId) {
        return !userPurchasedProductsDao.findAllPurchasedProductsByUserIdAndProductId(
                userId,
                productId
        ).isEmpty();
    }

}
