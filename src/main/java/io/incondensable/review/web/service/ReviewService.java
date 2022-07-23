package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductWithVotesResponse;

public interface ReviewService {

    ProductWithVotesResponse showProductsWithApprovedCommentsAndVotes(long productId);

}
