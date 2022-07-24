package io.incondensable.review.domain.service;

import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.domain.repository.CommentRepository;
import io.incondensable.review.global.constants.Constants;
import io.incondensable.review.web.dto.ProductCommentsResponseDto;
import io.incondensable.review.web.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * this Service is responsible for getting both Approved and UnApproved Comments
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductCommentsResponseDto> getAllCommentsOfProduct(Long productId) {
        List<Comment> comments = repository.getCommentsOfProduct(productId);

        return createDto(comments);
    }

    @Override
    public List<ProductCommentsResponseDto> getAllApprovedCommentsOfProduct(Long productId) {
        List<Comment> approvedComments = repository.getApprovedCommentsOfProduct(productId);

        return createDto(approvedComments);
    }

    private List<ProductCommentsResponseDto> createDto(List<Comment> input) {
        List<ProductCommentsResponseDto> response = new ArrayList<>();

        input.forEach(
                model -> response.add(
                        new ProductCommentsResponseDto(
                                model.getId(),
                                model.getContext(),
                                model.getProductId(),
                                model.getUserId(),
                                model.getStatus() == 1 ?
                                        Constants.VoteAndCommentStatus.NOT_APPROVED.getTitle()
                                        : Constants.VoteAndCommentStatus.APPROVED.getTitle()
                        ))
        );

        return response;
    }

}
