package io.incondensable.review.web.service;

import io.incondensable.review.web.dto.ProductVotesResponse;

public interface ReviewService {

    ProductVotesResponse showProductsWithApprovedCommentsAndVotes(long productId);

}
