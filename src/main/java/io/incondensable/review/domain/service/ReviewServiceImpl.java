package io.incondensable.review.domain.service;

import io.incondensable.review.domain.repository.ReviewRepository;
import io.incondensable.review.web.service.ReviewService;
import io.incondensable.review.web.dto.ProductVotesResponse;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ProductVotesResponse showProductsWithApprovedCommentsAndVotes(long productId) {
//        ProductEntity product = reviewRepository.findProductAndItsApprovedVotes(productId);
//
//        ProductWithVotesResponse response = new ProductWithVotesResponse(
//                product.getId(),
//                product.getDescription(),
//                product.getVotes().stream().filter(
//                        vote -> vote
//                )
//        );
        return null;
    }

}
