package io.incondensable.review.domain.repository;

import io.incondensable.review.data.model.ProductEntity;

public interface ReviewRepository {

    ProductEntity getProductAndItsApprovedCommentsAndVotes(long productId);

}
