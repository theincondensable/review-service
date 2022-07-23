package io.incondensable.review.domain.service.internal;

import io.incondensable.review.domain.model.Comment;
import io.incondensable.review.domain.repository.CommentRepository;
import io.incondensable.review.web.dto.ProductCommentsDto;
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
    public List<ProductCommentsDto> getAllCommentsOfProduct(Long productId) {
        List<Comment> comments = repository.getCommentsOfProduct(productId);

        return createDto(comments);
    }

    @Override
    public List<ProductCommentsDto> getAllApprovedCommentsOfProduct(Long productId) {
        List<Comment> approvedComments = repository.getApprovedCommentsOfProduct(productId);

        return createDto(approvedComments);
    }

    private List<ProductCommentsDto> createDto(List<Comment> input) {
        List<ProductCommentsDto> response = new ArrayList<>();

        input.forEach(
                model -> response.add(
                        new ProductCommentsDto(
                                model.getId(),
                                model.getContext(),
                                model.getProductId(),
                                model.getUserId()
                        ))
        );

        return response;
    }

}
